package com.example.tdd.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
