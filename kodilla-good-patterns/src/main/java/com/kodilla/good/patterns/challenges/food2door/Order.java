package com.kodilla.good.patterns.challenges.food2door;

public class Order {
    private Product product;
    private int quantity;
    private boolean isHandled;

    public Order(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
        this.isHandled = false;
    }

    public Product getProduct() { return product; }

    public int getQuantity() { return quantity; }

    public boolean isHandled() {
        return isHandled;
    }

    public void setHandled(boolean handled) {
        isHandled = handled;
    }
}