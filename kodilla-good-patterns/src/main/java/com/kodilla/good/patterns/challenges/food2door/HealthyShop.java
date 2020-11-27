package com.kodilla.good.patterns.challenges.food2door;

public class HealthyShop extends Shop {

    public HealthyShop(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void process(Order order) {
        System.out.println("HEALTHY received order, thank you");

    }

}
