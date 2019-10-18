package com.chef.order.facade;


import com.chef.order.mapper.OrderMapper;
import com.chef.order.model.Order;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


@Component
public class OrderFacadeImpl implements OrderFacade {

    private static String LIST_PARAMETER = "list";
    private static String KEY_ID = "orderId";

    @Value("${vtex.api.listOrder}")
    private String listOrderURL;

    @Value("${vtex.api.detailOrder}")
    private String detailOrderURL;


    Logger logger = LoggerFactory.getLogger(OrderFacadeImpl.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    OrderMapper orderMapper;


    /**
     * Get the list of orders.
     */
    @Override
    public List<Order> orderReport(){

        try {
            List<Order> orderReportResponse = new ArrayList<Order>();

            JSONObject response = restTemplate.getForObject(listOrderURL, JSONObject.class);
            List<LinkedHashMap<String, String>> myOrders = (List<LinkedHashMap<String, String>>) response.get(LIST_PARAMETER);

            this.getOrderDetails(orderReportResponse, myOrders);
            return orderReportResponse;

        } catch (Exception e) {
            logger.info("Error when consume the listOrderService" + e.getMessage());
            return null;
        }

    }


    /**
     * Get the orders details
     * @param response the list of order for the report
     * @param data Data obtained from the listOrder service
     */
    private void getOrderDetails(List<Order> response, List<LinkedHashMap<String, String>> data) throws Exception {

        try {
            for (LinkedHashMap<String, String> lhm : data) {

                Order order = new Order();
                order.setId(lhm.get(KEY_ID));

                JSONObject responseOrder = restTemplate.getForObject(detailOrderURL + order.getId(), JSONObject.class);

                response.add(orderMapper.mapOrder(order, responseOrder));

            }
        } catch (Exception e) {
            logger.info("Error when consume the detailOrderService" + e.getMessage());
        }

    }


}

