package com.pizzashop.restclient.models;

import javax.validation.constraints.NotNull;

public class Order {

    private long id;

    private String name;

    private String orderedProducts;

    protected Order(){}

    public Order(String name, String orderedProducts){
        this.name = name;
        this.orderedProducts = orderedProducts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrderedProducts() {
        return orderedProducts;
    }

    public void setOrderedProducts(String orderedProducts) {
        this.orderedProducts = orderedProducts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
