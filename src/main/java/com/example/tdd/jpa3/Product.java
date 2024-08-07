package com.example.tdd.jpa3;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "S_PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 상품아이디

    private String name; // 상품 이름

    @Column(name = "SHORT_DESC")
    private String shortDesc; // 상품 설명

    private String category;  // 카테고리

    @ManyToMany(mappedBy = "productList")
    private List<Order> orderList = new ArrayList<>();

    @OneToMany(mappedBy = "product")
    private List<Item> itemList = new ArrayList<>();
}
