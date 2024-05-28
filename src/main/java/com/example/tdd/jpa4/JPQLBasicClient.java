package com.example.tdd.jpa4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

public class JPQLBasicClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter06");
        try {
            dataInsert(emf);
            dataSelect(emf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        emf.close();
    }

    private static void dataSelect(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        // JPQL
        String jpql = "SELECT e FROM Employee AS e";

        // JPQL 전송 - 영속 컨테이너에 전송할 JPQL , JPQL 실행 결과를 매핑할 엔티티타입
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
        List<Employee> resultList = query.getResultList();

        // 검색 결과 처리
        System.out.println("검색된 직원 목록");
        for (Employee result : resultList) {
            System.out.println("---> " + result.toString());
        }
        em.close();
    }

    private static void dataInsert(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // 10명의 직원 정보 등록
        for(int i = 1; i <= 10; i++) {
            Employee employee = new Employee();
            employee.setName("직원 " + i);
            employee.setMailId("anti-corona" + i);
            employee.setDeptName("개발부");
            employee.setSalary(12700.00 * i);
            employee.setStartDate(new Date());
            employee.setTitle("사원");
            employee.setCommissionPct(15.00);
            em.persist(employee);
        }

        em.getTransaction().commit();
        em.close();
    }
}
