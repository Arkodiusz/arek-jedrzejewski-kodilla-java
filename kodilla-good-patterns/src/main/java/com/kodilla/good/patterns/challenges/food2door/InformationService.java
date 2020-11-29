package com.kodilla.good.patterns.challenges.food2door;

public class InformationService {

    public void terminal(Order orderRequest) {
        System.out.println("Ordered " +
                orderRequest.getProduct().getName() +
                " (" + orderRequest.getQuantity() + " pcs.) " +
                " for " + orderRequest.getProduct().getPrice() * orderRequest.getQuantity() + " PLN" +
                " \n Wait for delivery.");
    }
}