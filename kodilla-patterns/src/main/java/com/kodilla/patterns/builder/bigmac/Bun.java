package com.kodilla.patterns.builder.bigmac;

public enum Bun {
    WHEAT("wheat bun"),
    RYE("rye bun"),
    SESAME("wheat bun with sesame");

    private String name;

    Bun(String name) {
        this.name = name;
    }
}