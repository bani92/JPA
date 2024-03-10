package com.example.tdd.Mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SpyAnnotation {

    @Spy
    ProductService productService;

    @Test
    void testSpy_스터빙X() {
        Product product = productService.getProduct();
        assertEquals("A001",product.getSerial());
    }

    @Test
    void testSpy_스터빙O() {
        Product productDummy = new Product("B001","keyboard");

        when(productService.getProduct()).thenReturn(productDummy);
        Product product = productService.getProduct();
        assertEquals(productDummy.getSerial(), product.getSerial());
    }
}
