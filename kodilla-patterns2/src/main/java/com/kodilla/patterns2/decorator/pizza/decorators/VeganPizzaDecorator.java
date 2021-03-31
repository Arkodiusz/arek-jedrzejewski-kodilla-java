package com.kodilla.patterns2.decorator.pizza.decorators;

import com.kodilla.patterns2.decorator.pizza.Ingredients;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;

import java.util.List;

public class VeganPizzaDecorator extends AbstractPizzaOrderDecorator {

    public VeganPizzaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
        removeNotVeganProducts(pizzaOrder);
    }

    public void removeNotVeganProducts(PizzaOrder pizzaOrder) {
        List<Ingredients> list = pizzaOrder.getIngredients();
        list.removeIf(Ingredients::isNotVegan);

//        for (int i = 0; i < list.size(); i++) {
//            if (!list.get(i).isVegan()) {
//                list.remove(i);
//            }
//        }
    }
}
