package com.kodilla.good.patterns.challenges.allegro;

public class ProductOrderRetriever {

    public OrderRequest retrieve() {

        User user = new User("user123");

        int quantity = 5;

        return new OrderRequest(user, quantity);
    }

}
