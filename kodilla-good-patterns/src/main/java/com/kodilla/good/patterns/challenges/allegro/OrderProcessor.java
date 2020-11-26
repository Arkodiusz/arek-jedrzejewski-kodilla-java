package com.kodilla.good.patterns.challenges.allegro;

public class OrderProcessor {

    private ProductOrderService productOrderService;
    private ProductOrderRepository productOrderRepository;

    public OrderProcessor(final ProductOrderService productOrderService,
                           final ProductOrderRepository productOrderRepository) {
        this.productOrderService = productOrderService;
        this.productOrderRepository = productOrderRepository;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = productOrderService.order(orderRequest.getUser(), 5);

        if (isOrdered) {
            productOrderRepository.createOrder(orderRequest.getUser(), 5);
            return new OrderDto(orderRequest.getUser(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), false);
        }
    }
}