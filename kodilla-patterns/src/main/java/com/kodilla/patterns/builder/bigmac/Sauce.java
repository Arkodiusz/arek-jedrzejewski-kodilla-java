package com.kodilla.patterns.builder.bigmac;

public enum Sauce {
    STANDARD("standard sauce"),
    THOUSAND("thousand islands dressing"),
    BARBECUE("barbecue sauce");

    private String name;

    Sauce(String name) {
        this.name = name;
    }
}