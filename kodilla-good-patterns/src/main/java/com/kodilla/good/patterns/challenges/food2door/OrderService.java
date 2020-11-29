package com.kodilla.good.patterns.challenges.food2door;

import java.util.HashMap;
import java.util.Map;

public class OrderService {

    public static Map<Product, Shop> products = new HashMap<>();

    private static Shop extraFoodShop = new ExtraFoodShop("Extra Food");
    private static Shop glutenFreeShop = new GlutenFreeShop("Gluten Free");
    private static Shop healthyShop = new HealthyShop("Healthy");

    public static Product lays = new Product("Lay's", 4.50);
    public static Product soyMilk = new Product("Soy Milk", 6.00);
    public static Product avocado = new Product("Avocado", 3.00);
    public static Product juiceOrange = new Product("Orange Juice", 4.30);
    public static Product juiceApple = new Product("Apple Juice", 4.25);

    public static void fillProductsDB(){
        products.put(lays, extraFoodShop);
        products.put(soyMilk, glutenFreeShop);
        products.put(avocado, glutenFreeShop);
        products.put(juiceOrange, healthyShop);
        products.put(juiceApple, healthyShop);
    }

    public static boolean handle(Order order) {
        if(order.isHandled() == false) {
            if(products.containsKey(order.getProduct())) {
                products.get(order.getProduct()).process(order);
                order.setHandled(true);
            }
        }
        return order.isHandled();
    }
}