package com.example.tdd.jpaFinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductReposiotry productReposiotry;

    // 상품 등록 혹은 수정
    public void insertOrUpdateProduct(Product product) {
        productReposiotry.insertOrUpdateProduct(product);
    }

    // 상품 상세 조회
    public Product getProduct(Long productId) {
        return productReposiotry.getProduct(productId);
    }

    // 상품 목록 검색
    public List<Product> getProductList() {
        return productReposiotry.getProductList();
    }
}
