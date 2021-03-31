package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.pizza.decorators.ExtraCheesePizzaDecorator;
import com.kodilla.patterns2.decorator.pizza.decorators.HawaiiPizzaDecorator;
import com.kodilla.patterns2.decorator.pizza.decorators.HotPizzaDecorator;
import com.kodilla.patterns2.decorator.pizza.decorators.VeganPizzaDecorator;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaOrderTests {
    @Test
        // [6]
    void testBasicPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(BigDecimal.valueOf(15.0), calculatedCost);
    }

    @Test
    void testBasicPizzaOrderGetDIngredients() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        // When
        List<Ingredients> list = theOrder.getIngredients();
        System.out.println(list);
        // Then
        assertEquals(3, list.size());
    }

    @Test
        // [6]
    void testHotPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HotPizzaDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(BigDecimal.valueOf(18.0), calculatedCost);
    }

    @Test
    void testHotPizzaOrderGetDIngredients() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HotPizzaDecorator(theOrder);
        // When
        List<Ingredients> list = theOrder.getIngredients();
        System.out.println(list);
        // Then
        assertEquals(4, list.size());
    }

    @Test
    void testHawaiiHotPizzaOrderGetDIngredients() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HotPizzaDecorator(theOrder);
        theOrder = new HawaiiPizzaDecorator(theOrder);
        // When
        List<Ingredients> list = theOrder.getIngredients();
        System.out.println(list);
        // Then
        assertEquals(5, list.size());
    }

    @Test
    void testHawaiiHotPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HotPizzaDecorator(theOrder);
        theOrder = new HawaiiPizzaDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(BigDecimal.valueOf(21.0), calculatedCost);
    }

    @Test
    void testVeganPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new VeganPizzaDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        // Then
        assertEquals(BigDecimal.valueOf(12.0), calculatedCost);
        assertEquals(2, theOrder.getIngredients().size());
    }

    @Test
    void testVeganHawaiiHotPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new HawaiiPizzaDecorator(theOrder);
        theOrder = new HotPizzaDecorator(theOrder);
        theOrder = new VeganPizzaDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println(theOrder.getIngredients());
        // Then
        assertEquals(BigDecimal.valueOf(18.0), calculatedCost);
        assertEquals(4, theOrder.getIngredients().size());
    }

    @Test
    void testExtraCheeseHotPizzaOrderGetCost() {
        // Given
        PizzaOrder theOrder = new BasicPizzaOrder();
        theOrder = new ExtraCheesePizzaDecorator(theOrder);
        theOrder = new HotPizzaDecorator(theOrder);
        // When
        BigDecimal calculatedCost = theOrder.getCost();
        System.out.println(theOrder.getIngredients());
        // Then
        assertEquals(BigDecimal.valueOf(24.0), calculatedCost);
        assertEquals(6, theOrder.getIngredients().size());
    }

}