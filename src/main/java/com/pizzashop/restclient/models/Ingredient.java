package com.pizzashop.restclient.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {

    private long id;

    private String name;

    //private String content_type;

    protected Ingredient(){}

    public Ingredient(String name){ this.name = name; }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
