package com.kodilla.good.patterns.challenges.food2door;

import static com.kodilla.good.patterns.challenges.food2door.OrderService.handle;

public class App {

    public static void main(String[] args) {

        Shop extraFoodShop = new ExtraFoodShop("Extra Food");
        Shop glutenFreeShop = new GlutenFreeShop("Gluten Free");
        Shop healthyShop = new HealthyShop("Healthy");

        Product lays = new Product("Lay's", 4.50);
        Product soyMilk = new Product("Soy Milk", 6.00);
        Product avocado = new Product("Avocado", 3.00);

        Order order1 = new Order(extraFoodShop, lays, 1);
        Order order2 = new Order(glutenFreeShop, soyMilk, 6);
        Order order3 = new Order(healthyShop, avocado, 2);

        InformationService info = new InformationService();

        if (handle(order1)) info.terminal(order1);
        if (handle(order2)) info.terminal(order2);
        if (handle(order3)) info.terminal(order3);

    }

}
