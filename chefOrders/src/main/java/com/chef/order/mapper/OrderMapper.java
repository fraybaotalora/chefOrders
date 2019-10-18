package com.chef.order.mapper;

import com.chef.order.model.Client;
import com.chef.order.model.Item;
import com.chef.order.model.Order;
import com.chef.order.model.Payment;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

@Component
public class OrderMapper {


    Logger logger = LoggerFactory.getLogger(OrderMapper.class);

    /**
     * Map the diferents params of a order.
     */
    public Order mapOrder(Order order, JSONObject responseOrder) throws Exception {

        try {
            order.setSequence((String) responseOrder.get("sequence"));
            order.setStatus((String) responseOrder.get("status"));

            this.mapClient((LinkedHashMap<String, String>) responseOrder.get("clientProfileData"), order);
            this.mapItem((List<LinkedHashMap<String, Object>>) responseOrder.get("items"), order);
            this.mapShippingData((LinkedHashMap<String, Object>) responseOrder.get("shippingData"), order);
            this.mapLogisticInfo((LinkedHashMap<String, Object>) responseOrder.get("shippingData"), order);
            this.mapPaymentData((LinkedHashMap<String, Object>) responseOrder.get("paymentData"), order);
            this.mapDiscounts((List<ArrayList<Object>>) responseOrder.get("totals"), order);
            this.mapCreationDate(responseOrder.get("creationDate"), order);
            order.setOrders(order.getItem().size());

            return order;
        } catch (Exception e) {
            logger.info("Error while mapping the order" + e.getMessage());
            return null;


        }
    }

    /**
     * Add creationData to the order.
     */
    private void mapCreationDate(Object date, Order order) {
        ZonedDateTime zdt = ZonedDateTime.parse(date.toString());
        order.setCreationDate(zdt.toLocalDateTime());
    }

    /**
     * Add the value and id Discounts to the order.
     */
    private void mapDiscounts(List<ArrayList<Object>> data, Order order) {

        for (Object obj : data) {
            LinkedHashMap<String, Object> lhm = (LinkedHashMap<String, Object>) obj;
            if (lhm.get("id").toString().equals("Discounts")) {
                order.setDiscountName((String) lhm.get("id"));
                order.setDiscountTotal(Integer.parseInt(lhm.get("value").toString()));
            }
        }
    }

    /**
     * Add the different payments method to the order.
     */
    private void mapPaymentData(LinkedHashMap<String, Object> paymentData, Order order) {
        ArrayList<Payment> payment = new ArrayList<Payment>();
        List<Object> transactions = (List<Object>) paymentData.get("transactions");

        for (Object o : transactions) {
            LinkedHashMap<String, Object> t = (LinkedHashMap<String, Object>) o;
            List<Object> payments = (List<Object>) t.get("payments");

            for (Object p : payments) {
                Payment ps = new Payment();
                LinkedHashMap<String, Object> lhm = (LinkedHashMap<String, Object>) p;
                ps.setId((String) lhm.get("id"));
                ps.setPaymentSystemName((String) lhm.get("paymentSystemName"));
                ps.setPaymentValue((Integer) lhm.get("value"));
                payment.add(ps);
            }

        }
        order.setPayment(payment);

    }

    /**
     * Add shipping
     *
     * @param data
     * @param order
     */
    private void mapShippingData(LinkedHashMap<String, Object> data, Order order) {

        try {

            List<LinkedHashMap<String, Object>> logisticsInfo = (List<LinkedHashMap<String, Object>>) data.get("logisticsInfo");


            for (LinkedHashMap<String, Object> lhm : logisticsInfo) {
                order.setShippingListPrice(order.getShippingListPrice() + (Integer) lhm.get("listPrice"));
                order.setShippingValue(order.getShippingValue() + (Integer) lhm.get("sellingPrice"));
                order.setTotalValue(order.getTotalValue() + (Integer) lhm.get("price"));
            }
        } catch (Exception e) {

        }

    }

    /**
     * Add the logistic delivery to the order.
     */
    private void mapLogisticInfo(LinkedHashMap<String, Object> data, Order order) {
        LinkedHashMap<String, Object> address = (LinkedHashMap<String, Object>) data.get("address");
        order.setUf((String) address.get("state"));
        order.setCity((String) address.get("city"));

    }


    /**
     * Add the client to the order.
     */
    private void mapClient(LinkedHashMap<String, String> clientProfileData, Order order) {

        Client client = new Client();

        client.setDocument(clientProfileData.get("document"));
        client.setEmail(clientProfileData.get("email"));
        client.setLastName(clientProfileData.get("lastName"));
        client.setFirstName(clientProfileData.get("firstName"));
        client.setPhone(clientProfileData.get("phone"));

        order.setClient(client);

    }

    /**
     * Add the items  to the order.
     */
    private void mapItem(List<LinkedHashMap<String, Object>> items, Order order) {

        order.setItem(new ArrayList<Item>());
        for (LinkedHashMap<String, Object> lhm : items) {
            Item item = new Item();
            item.setIdSku(Integer.parseInt(lhm.get("id").toString()));
            item.setSkuName((String) lhm.get("name"));
            item.setGender((String) lhm.get("name"));
            item.setSkuValue(Integer.parseInt(lhm.get("listPrice").toString()));
            item.setSkuPath((String) lhm.get("detailUrl"));
            item.setSkuQuantity(Integer.parseInt(lhm.get("quantity").toString()));
            item.setSellingPrice(Integer.parseInt(lhm.get("price").toString()));

            LinkedHashMap<String, String> additionalInfo = (LinkedHashMap<String, String>) lhm.get("additionalInfo");
            item.setBrandName(additionalInfo.get("brandName"));

            order.getItem().add(item);
        }

    }




}
