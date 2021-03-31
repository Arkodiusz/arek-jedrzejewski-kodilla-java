package com.kodilla.patterns2.decorator.pizza.decorators;

import com.kodilla.patterns2.decorator.pizza.Ingredients;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;

public class HotPizzaDecorator extends AbstractPizzaOrderDecorator {
    public HotPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
        pizzaOrder.getIngredients().add(Ingredients.JALAPENO);
    }
}
