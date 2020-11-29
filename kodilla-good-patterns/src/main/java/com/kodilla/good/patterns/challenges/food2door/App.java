package com.kodilla.good.patterns.challenges.food2door;

import static com.kodilla.good.patterns.challenges.food2door.OrderService.*;

public class App {

    public static void main(String[] args) {

        Order order1 = new Order(lays, 1);
        Order order2 = new Order(soyMilk, 6);
        Order order3 = new Order(avocado, 2);

        InformationService info = new InformationService();

        fillProductsDB();

        if (handle(order1)) info.terminal(order1);
        if (handle(order2)) info.terminal(order2);
        if (handle(order3)) info.terminal(order3);
    }
}
