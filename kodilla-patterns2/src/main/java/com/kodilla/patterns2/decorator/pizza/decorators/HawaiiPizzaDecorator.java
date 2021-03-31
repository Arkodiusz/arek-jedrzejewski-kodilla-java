package com.kodilla.patterns2.decorator.pizza.decorators;

import com.kodilla.patterns2.decorator.pizza.Ingredients;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;

public class HawaiiPizzaDecorator extends AbstractPizzaOrderDecorator {

    public HawaiiPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
        pizzaOrder.getIngredients().add(Ingredients.PINEAPPLE);
    }
}
