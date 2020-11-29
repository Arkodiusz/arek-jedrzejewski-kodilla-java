package com.kodilla.good.patterns.challenges.food2door;

public class HealthyShop extends Shop {

    public HealthyShop(String name) {
        this.name = name;
    }

    public void process(Order order) {
        System.out.println("HEALTHY received order ( +" +
                order.getProduct() +
                " x " +
                order.getQuantity() +
                "), thank you");
        order.setHandled(true);
    }
}