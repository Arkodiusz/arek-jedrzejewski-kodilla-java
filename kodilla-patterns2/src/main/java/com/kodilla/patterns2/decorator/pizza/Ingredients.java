package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public enum Ingredients {
    DOUGH("DOUGH", BigDecimal.valueOf(10.00), true),
    TOMATO_SAUCE("TOMATO SAUCE", BigDecimal.valueOf(2.00), true),
    MOZZARELLA("MOZZARELLA", BigDecimal.valueOf(3.00), false),
    PARMESAN("PARMESAN", BigDecimal.valueOf(3.00), false),
    PINEAPPLE("PINEAPPLE", BigDecimal.valueOf(3.00), true),
    JALAPENO("JALAPENO", BigDecimal.valueOf(3.00), true);

    private String name;
    private BigDecimal price;
    private boolean isVegan;

    Ingredients(String name, BigDecimal price, boolean isVegan) {
        this.name = name;
        this.price = price;
        this.isVegan = isVegan;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isVegan() {
        return isVegan;
    }

    public boolean isNotVegan() {
        return !isVegan;
    }


}
