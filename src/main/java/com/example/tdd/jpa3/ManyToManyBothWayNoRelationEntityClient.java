package com.example.tdd.jpa3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class ManyToManyBothWayNoRelationEntityClient {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter05");

        try {
            dataInsert(emf);
            dataSelect(emf);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emf.close();
        }
    }

    private static void dataSelect(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        // 검색한 Order를 통해 Product 목록을 출력한다.
        Order order = em.find(Order.class, 1L);
        System.out.println(order.getId() + "번 주문에 대한 상품 목록");

        List<Product> productList = order.getProductList();
        for (Product product : productList) {
            System.out.println("---> " + product.getName());
        }
    }

    private static void dataInsert(EntityManagerFactory emf) throws ParseException {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // 1번 상품 등록
        Product product1 = new Product();
        product1.setName("LG 통돌이 세탁기");
        em.persist(product1);

        // 2번 상품 등록
        Product product2 = new Product();
        product2.setName("다이슨 청소기");
        em.persist(product2);

        // 1번 주문 등록
        Order order = new Order();
        order.setOrderDate(new Date());

        // 주문 객체가 가진 상품목록에 상품 저장
        order.getProductList().add(product1);
        order.getProductList().add(product2);
        em.persist(order);

        em.getTransaction().commit();
        em.close();
    }
}
