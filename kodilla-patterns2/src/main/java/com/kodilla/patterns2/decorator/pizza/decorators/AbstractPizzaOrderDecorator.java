package com.kodilla.patterns2.decorator.pizza.decorators;

import com.kodilla.patterns2.decorator.pizza.Ingredients;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;
import java.util.List;

public abstract class AbstractPizzaOrderDecorator implements PizzaOrder {

    private PizzaOrder pizzaOrder;

    protected AbstractPizzaOrderDecorator(PizzaOrder pizzaOrder) {
        this.pizzaOrder = pizzaOrder;
    }

    @Override
    public BigDecimal getCost() {
        return pizzaOrder.getCost();
    }

    @Override
    public List<Ingredients> getIngredients() {
        return pizzaOrder.getIngredients();
    }
}
