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

    // Employee 엔티티가 관리 상태로 전환될때 연관관계에 있는 Department 엔티티도 같이 관리 상태로 전환
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "DEPT_ID")
    private Department dept;

    @Enumerated(EnumType.STRING)
    private MemberType memberType;

    public void setDept(Department dept) {
        this.dept = dept;

        if(dept != null) {
            dept.getEmployeeList().add(this);
        }
    }

    // 부서 정보를 null로 설정하여 직원을 대기 상태로 전환시킨다.
    public void standby() {
        this.dept = null;
    }
}
