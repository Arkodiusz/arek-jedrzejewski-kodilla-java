package com.kodilla.good.patterns.challenges.allegro;

public class ProductOrderService {

    public boolean order(final User user, final int quantity) {
        System.out.println("User " + user.getNickname() + " ordered " + quantity + " pcs.");
        return true;
    }
}

