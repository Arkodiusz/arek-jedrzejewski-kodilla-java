package com.kodilla.good.patterns.challenges.food2door;

public abstract class Shop {

    protected String name;

    public String getName() {
        return name;
    }

    abstract void process(Order order);

}
