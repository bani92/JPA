package com.example.tdd.Mock;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
public class InjectMocksAnnotation {

    @Mock
    UserService userService;

    @Spy
    ProductService productService;

    @InjectMocks
    OrderService orderService;

    @Test
    void testGetUser() {
        assertNull(orderService.getUser());
    }

    @Test
    void testGetProduct() {
        Product product = orderService.getProduct();
        assertEquals("A001",product.getSerial());
    }
}
