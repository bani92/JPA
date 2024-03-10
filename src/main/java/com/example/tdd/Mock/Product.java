package com.example.tdd.Mock;

public class Product {

    private String id;
    private String password;

    public Product(String id , String password) {
        this.id = id;
        this.password = password;
    }

    public String getSerial() {
        return id;
    }
}
