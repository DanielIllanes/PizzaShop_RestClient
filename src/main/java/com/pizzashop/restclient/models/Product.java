package com.pizzashop.restclient.models;

public class Product {

    private long id;

    private String product_type;

    private String product_id;

    protected Product(){}

    public Product(String product_type, String product_id){
        this.product_type = product_type;
        this.product_id = product_id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductType() {
        return product_type;
    }

    public void setProductType(String productType) {
        this.product_type = productType;
    }

    public String getProductId() {
        return product_id;
    }

    public void setProductId(String productId) {
        this.product_id = productId;
    }
}
