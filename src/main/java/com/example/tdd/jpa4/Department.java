package com.example.tdd.jpa4;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(exclude = "employeeList")
@Entity
@Table(name = "S_DEPT")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPT_ID")
    private Long deptId;

    private String name;

    @OneToMany(mappedBy = "dept")
    private List<Employee> employeeList = new ArrayList<>();
}
