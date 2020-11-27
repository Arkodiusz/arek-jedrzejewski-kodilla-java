package com.kodilla.good.patterns.challenges.food2door;

public class ExtraFoodShop extends Shop {

    public ExtraFoodShop(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void process(Order order) {
        System.out.println("EXTRA FOOD received order, thank you");

    }

}
