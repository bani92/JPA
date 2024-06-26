package com.example.tdd.jpaFinal;

import org.springframework.context.support.GenericXmlApplicationContext;

public class RubbyShoppingClient {

    public static void main(String[] args) {
        // 스프링 컨테이너 생성
        String configLocation = "classpath:spring/business-layer.xml";
        GenericXmlApplicationContext container = new GenericXmlApplicationContext(configLocation);

        // 서비스 컴포넌트 검색(Lookup)
        CustomerService customerService = (CustomerService) container.getBean("customerService");
        ProductService productService = (ProductService) container.getBean("productService");
        OrderService orderService = (OrderService) container.getBean("orderService");

        insertData(customerService, productService, orderService);

        // 스프링 컨테이너 종료
        container.close();

    }

    private static void insertData(CustomerService customerService, ProductService productService, OrderService orderService) {
        // 회원 정보 생성 및 등록
        Customer customer = new Customer();
        customer.setName("홍길동");
        Address address = new Address();
        address.setCity("서울시");
        address.setRoadName("행당로 82");
        address.setZipCode("123-123");
        customer.setAddress(address);
        customer.setPhone("011-1234-5678");
        customer.setComments("반품 요청이 많은 회원임");

        customerService.insertCustomer(customer);

        // 두 개의 상품 정보 생성 및 등록
        Product product = new Product();
        product.setName("JPA 처음 가보는 길");
        product.setPrice(20000);
        product.setQuantity(10);
        productService.insertOrUpdateProduct(product);

        Product product2 = new Product();
        product2.setName("자바 프로그래밍 기초");
        product2.setPrice(40000);
        product2.setQuantity(20);
        productService.insertOrUpdateProduct(product2);

        // 주문 정보 생성
        orderService.insertOrder(customer.getId(), product.getId(), 5);

    }

}
