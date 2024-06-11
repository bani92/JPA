package com.example.tdd.jpa5;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString(exclude = "dept")
@Entity
@Table(name = "S_EMP")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "MAIL_ID")
    private String mailId;

    private Double salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DEPT_ID")
    private Department dept;

    public void setDept(Department department) {
        this.dept = department;

        department.getEmployeeList().add(this);

    }
}
