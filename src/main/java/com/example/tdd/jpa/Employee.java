package com.example.tdd.jpa;

import jakarta.persistence.*;
import jakarta.persistence.EnumType;
import lombok.Data;

@Data
@Entity
@Table(name = "S_EMP")
public class Employee {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 25, nullable = false)
    private String name;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPT_ID")
    private Department dept;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;
}
