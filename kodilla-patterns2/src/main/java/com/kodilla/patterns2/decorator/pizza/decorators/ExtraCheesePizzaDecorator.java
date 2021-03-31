package com.kodilla.patterns2.decorator.pizza.decorators;

import com.kodilla.patterns2.decorator.pizza.Ingredients;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;

public class ExtraCheesePizzaDecorator extends AbstractPizzaOrderDecorator {

    public ExtraCheesePizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
        pizzaOrder.getIngredients().add(Ingredients.MOZZARELLA);
        pizzaOrder.getIngredients().add(Ingredients.PARMESAN);
    }
}
