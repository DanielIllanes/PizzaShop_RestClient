package com.pizzashop.restclient.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pizza {

    private long id;

    private String pizzatype;

    private Crust crust;

    private Cheese cheese;

    private Sauce sauce;

    private String toppings;

    private String ingredients;

    protected Pizza(){}

    public Pizza(String pizzatype, Sauce sauce, Cheese cheese, Crust crust, String toppings, String ingredients){
        this.pizzatype = pizzatype;
        this.sauce = sauce;
        this.cheese = cheese;
        this.crust = crust;
        this.toppings = toppings;
        this.ingredients = ingredients;
    }

    public void setPizzatype(String pizzatype){
        this.pizzatype = pizzatype;
    }

    public String getPizzatype(){
        return this.pizzatype;
    }

    public Crust getCrust() {
        return crust;
    }

    public void setCrust(Crust crust) {
        this.crust = crust;
    }

    public Cheese getCheese() {
        return cheese;
    }

    public void setCheese(Cheese cheese) {
        this.cheese = cheese;
    }

    public Sauce getSauce() {
        return sauce;
    }

    public void setSauce(Sauce sauce) {
        this.sauce = sauce;
    }

    public String getToppings() {
        return toppings;
    }

    public void setToppings(String toppings) {
        this.toppings = toppings;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
