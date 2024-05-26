package com.example.tdd.jpa3;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString(exclude = "itemList")
@Entity
@Table(name = "S_ORD")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 주문 아이디

    @Column(name = "CUSTOMER_ID")
    private Long customerId; // 고객 아이디

    @Column(name = "ORDER_DATE")
    private Date orderDate;  // 주문 날짜

    private Double total;   // 주문 금액

    @ManyToMany
    @JoinTable(name = "S_ITEM", joinColumns = @JoinColumn(name = "ORD_ID"), inverseJoinColumns = @JoinColumn(name = "PRODUCT_ID"),
                uniqueConstraints = @UniqueConstraint(columnNames = {"ORD_ID","PRODUCT_ID"}))
    private List<Product> productList = new ArrayList<>();

    // 상품(Product)을 등록할 떄, 상품쪽에 주문(Order) 정보도 설정한다.
    public void addProduct(Product product) {
        productList.add(product);

        // 반대쪽(Product)에도 주문에 대한 참조 정보를 설정한다.
        product.getOrderList().add(this);
    }

    @OneToMany(mappedBy = "order")
    private List<Item> itemList = new ArrayList<>();
}
