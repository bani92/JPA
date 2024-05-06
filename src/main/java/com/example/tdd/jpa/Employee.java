package com.example.tdd.jpa;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "S_EMP")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    private Department dept;
}
