package com.example.tdd.jpa2;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "S_EMP2")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25, nullable = false)
    private String name;

    @OneToOne(mappedBy = "employee")
    private EmployeeCard card;
}
