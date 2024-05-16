package com.example.tdd.jpa;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "S_DEPT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID")
    private Long deptId;

    @Column(length = 25, nullable = false)
    private String name;

    @OneToMany(mappedBy = "dept", cascade = { CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Employee> employeeList = new ArrayList<>();

}
