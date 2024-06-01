package com.example.tdd.jpa4;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import java.util.Date;
import java.util.List;

public class JPQLJoinClient {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter06");
        try {
        //    dataInsert(emf);
            dataSelect(emf);
        } catch (Exception e) {
            e.printStackTrace();
        }
        emf.close();
    }

    private static void dataSelect(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT e FROM Employee e LEFT JOIN FETCH e.dept";
        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);

//        String jpql = "SELECT e, d FROM Employee e, Department d " + "WHERE e.name = d.name";
//        TypedQuery<Object[]> query = em.createQuery(jpql, Object[].class);
//
//        List<Object[]> resultList = query.getResultList();
//        System.out.println("검색된 직원 목록");
//        for (Object[] result : resultList) {
//            Employee employee = (Employee) result[0];
//            Department department = (Department) result[1];
//            System.out.println(employee.getName() + "의 부서 " + department.getName());
//        }

//        String jpql = "SELECT e FROM Employee e";
//        TypedQuery<Employee> query = em.createQuery(jpql, Employee.class);
//
        List<Employee> resultList = query.getResultList();
        System.out.println("검색된 직원 목록");
        for (Employee employee : resultList) {
            System.out.println(employee.getName());
        }
        em.close();
    }

    private static void dataInsert(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Department department = new Department();
        department.setName("개발부");
        for (int i = 1; i<= 3; i++) {
            Employee employee = new Employee();
            employee.setName("개발직원 " + i);
            employee.setSalary(i * 12700.00);
            employee.setMailId("Dev-" + i);
            employee.setDept(department);
        }
        em.persist(department);


        Department department2 = new Department();
        department2.setName("개발부");
        for (int i = 1; i<= 3; i++) {
            Employee employee = new Employee();
            employee.setName("개발직원 " + i);
            employee.setSalary(i * 12700.00);
            employee.setMailId("Dev-" + i);
            employee.setDept(department2);
        }
        em.persist(department2);

        Department department3 = new Department();
        department3.setName("인재개발부");
        em.persist(department3);

        // 부서 정보가 없는 새로운 직원추가
        Employee employee = new Employee();
        employee.setName("아르바이트");
        employee.setMailId("Alba-01");
        employee.setSalary(10000.00);
        em.persist(employee);

        Employee employee2 = new Employee();
        employee2.setName("영업부");
        em.persist(employee2);

        em.getTransaction().commit();
        em.close();
    }
}
