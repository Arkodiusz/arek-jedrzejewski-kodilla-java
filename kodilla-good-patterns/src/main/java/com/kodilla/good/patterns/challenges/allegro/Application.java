package com.kodilla.good.patterns.challenges.allegro;

public class Application {
    public static void main(String[] args) {
        ProductOrderRetriever productOrderRetriever = new ProductOrderRetriever();
        OrderRequest orderRequest = productOrderRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new ProductOrderService(), new ProductOrderRepository());
        orderProcessor.process(orderRequest);
    }
}
