package com.kodilla.good.patterns.challenges.food2door;

public class OrderService {

    public static boolean handle(Order order) {

        if(!order.isHandled()) {

            order.getShop().process(order);
            order.setHandled(true);
        }
        return order.isHandled();
    }

}