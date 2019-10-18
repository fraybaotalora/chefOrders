package com.chef.order.model;

public class Item {

    private Integer idSku;
    private String skuName;
    private String gender;
    private String brandName;
    private Integer skuValue;
    private String skuPath;
    private Integer skuQuantity;
    private Integer sellingPrice;

    public int getIdSku() {
        return idSku;
    }

    public void setIdSku(int idSku) {
        this.idSku = idSku;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getSkuValue() {
        return skuValue;
    }

    public void setSkuValue(Integer skuValue) {
        this.skuValue = skuValue;
    }

    public String getSkuPath() {
        return skuPath;
    }

    public void setSkuPath(String skuPath) {
        this.skuPath = skuPath;
    }

    public Integer getSkuQuantity() {
        return skuQuantity;
    }

    public void setSkuQuantity(Integer skuQuantity) {
        this.skuQuantity = skuQuantity;
    }

    public Integer getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Integer sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
}
