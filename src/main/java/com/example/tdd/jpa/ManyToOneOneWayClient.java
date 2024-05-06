package com.example.tdd.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

public class ManyToOneOneWayClient {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        try {
            dataInsert(emf);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            emf.close();
        }
    }

    private static void dataInsert(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // 부서 등록
        Department department = new Department();
        department.setName("개발부");
        em.persist(department);

        // 직원 등록
        Employee employee = new Employee();
        employee.setName("둘리");
        employee.setDept(department);
        em.persist(employee);

        Employee employee2 = new Employee();
        employee2.setName("도우너");
        employee2.setDept(department);
        em.persist(employee2);

        em.getTransaction().commit();
        em.close();
    }
}
