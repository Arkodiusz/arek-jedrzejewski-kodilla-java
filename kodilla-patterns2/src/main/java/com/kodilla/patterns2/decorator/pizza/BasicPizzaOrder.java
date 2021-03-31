package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BasicPizzaOrder implements PizzaOrder {
    private List<Ingredients> ingredients = new ArrayList<>();

    public BasicPizzaOrder() {
        this.ingredients.add(Ingredients.DOUGH);
        this.ingredients.add(Ingredients.TOMATO_SAUCE);
        this.ingredients.add(Ingredients.PARMESAN);
    }

    @Override
    public BigDecimal getCost() {
        return (ingredients.stream().map(Ingredients::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
    }

    @Override
    public List<Ingredients> getIngredients() {
        return ingredients;
    }
}
