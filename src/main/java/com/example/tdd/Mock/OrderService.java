package com.example.tdd.Mock;

public class OrderService {

    UserService userService;
    ProductService productService;

    public OrderService(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    public User getUser() {
        return userService.getUser();
    }

    public Product getProduct() {
        return productService.getProduct();
    }
}
