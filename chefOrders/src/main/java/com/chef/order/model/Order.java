package com.chef.order.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private String id;
    private Client client;
    private List<Item> item;
    private int orders;
    private String sequence;
    private LocalDateTime creationDate;
    private String uf;
    private String city;
    private String status;
    private List<Payment> payment;
    private Integer discountTotal;
    private String discountName;
    private Integer totalValue;
    private Integer shippingListPrice;
    private Integer shippingValue;


    public Order() {
        this.totalValue = new Integer(0);
        this.shippingListPrice = new Integer(0);
        this.shippingValue = new Integer(0);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client clientProfileData) {
        this.client = clientProfileData;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public int getOrders() {
        return orders;
    }

    public void setOrders(int orders) {
        this.orders = orders;
    }

    public String getSequence() {
        return sequence;
    }

    public void setSequence(String sequence) {
        this.sequence = sequence;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDiscountTotal() {
        return discountTotal;
    }

    public void setDiscountTotal(Integer discountTotal) {
        this.discountTotal = discountTotal;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public Integer getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Integer totalValue) {
        this.totalValue = totalValue;
    }

    public Integer getShippingListPrice() {
        return shippingListPrice;
    }

    public void setShippingListPrice(Integer shippingListPrice) {
        this.shippingListPrice = shippingListPrice;
    }

    public Integer getShippingValue() {
        return shippingValue;
    }

    public void setShippingValue(Integer shippingValue) {
        this.shippingValue = shippingValue;
    }

    public List<Payment> getPayment() {
        return payment;
    }

    public void setPayment(List<Payment> payment) {
        this.payment = payment;
    }
}
