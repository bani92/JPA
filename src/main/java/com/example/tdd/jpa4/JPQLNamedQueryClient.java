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
            dataUpdate(emf);
         //   dataDelete(emf);
         //   dataSelect(emf);

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

    private static void dataUpdate(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Employee findEmp = em.find(Employee.class, 3L);
        System.out.println("수정 전 급여 : " + findEmp.getSalary());

        Query query = em.createQuery("UPDATE Employee e " + "SET e.salary=salary * 1.3 " + "WHERE e.id=:empId");
        query.setParameter("empId", 3L);
        int updateCnt = query.executeUpdate();
        System.out.println("updateCnt = " + updateCnt);

        System.out.println("수정 후 급어 : " + findEmp.getSalary() + " name = " + findEmp.getName());

        String jpql = "SELECT e FROM Employee e WHERE e.id = 3L";
        query = em.createQuery(jpql);
        Employee employee = (Employee) query.getSingleResult();
        System.out.println(employee.getId() + "번 직원의 수정된 급여 : " + employee.getSalary());


//        Query query = em.createQuery("UPDATE Employee e SET e.dept = :department " + "WHERE e.id = :empId");
//        Department findDept = em.find(Department.class, 1L);
//        query.setParameter("department", findDept);
//        query.setParameter("empId", 7L);
//        int updateCount = query.executeUpdate();
//        System.out.println("updateCount = " + updateCount);
        em.getTransaction().commit();
        em.close();

    }

    private static void dataDelete(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("DELETE Employee e WHERE e.name = :empName");
        query.setParameter("empName", "아르바이트");
        int updateCount = query.executeUpdate();
        System.out.println("updateCount = " + updateCount);


    }
}
