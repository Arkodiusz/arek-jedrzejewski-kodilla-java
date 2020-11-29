package com.kodilla.good.patterns.challenges.food2door;

public class GlutenFreeShop extends Shop {

    public GlutenFreeShop(String name) {
        this.name = name;
    }

    public void process(Order order) {
        System.out.println("GLUTEN FREE received order, thank you");
        order.setHandled(true);
    }
}