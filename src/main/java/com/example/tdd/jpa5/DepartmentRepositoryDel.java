package com.example.tdd.jpa5;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class DepartmentRepositoryDel {

    @PersistenceContext
    private EntityManager em;

    public void insertDepartment(Department department) {
        System.out.println("===> JPA로 insertDepartment() 기능 처리");
        em.persist(department);
    }

    public Department getDepartment(Department department) {
        System.out.println("===> JPA로 getDepartment() 기능 처리");
        return em.find(Department.class, department.getDeptId());
    }
}
