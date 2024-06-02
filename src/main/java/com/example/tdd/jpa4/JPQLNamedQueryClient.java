package com.example.tdd.jpa4;

import jakarta.persistence.*;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class JPQLNamedQueryClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter06");
        try {
          //  dataInsert(emf);
            dataSelect(emf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        emf.close();
    }

    private static void dataSelect(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

     //   String sql = "SELECT * FROM S_EMP WHERE DEPT_ID = :deptId ORDER BY SALARY DESC";
        Query query = em.createNamedQuery("Employee.searchByDeptId");
        query.setParameter("deptId", 2L);
        query.setFirstResult(0);
        query.setMaxResults(3);

        List<Object[]> resultList = query.getResultList();
        for (Object[] result : resultList) {
            System.out.println("---> " + Arrays.toString(result));
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