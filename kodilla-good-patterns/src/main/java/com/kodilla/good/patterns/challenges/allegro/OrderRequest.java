package com.kodilla.good.patterns.challenges.allegro;

public class OrderRequest {

    private User user;
    private int quantity;

    public OrderRequest(User user, int quantity) {
        this.user = user;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public int getQuantity() {
        return quantity;
    }
}
