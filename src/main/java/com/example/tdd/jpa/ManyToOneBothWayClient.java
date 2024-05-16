package com.example.tdd.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ManyToOneBothWayClient {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");

        try {
            dataInsert(emf);
        //    dataSelect(emf);
            dataDelete(emf);
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
     //   em.persist(department);

        // 직원 여러명 등록

        for(int i=1; i<=5; i++) {
            Employee employee = new Employee();
            employee.setName("직원-" + i);
            employee.setDept(department);

        }
        em.persist(department);
        // 직원 등록
//        Employee employee = new Employee();
//        employee.setName("둘리");
//        employee.setDept(department);
//        em.persist(employee);
//
//        Employee employee2 = new Employee();
//        employee2.setName("도우너");
//        employee2.setDept(department);
//        em.persist(employee2);


        System.out.println(department.getName() + "의 직원 수 : " + department.getEmployeeList().size());
        em.getTransaction().commit();
        em.close();
    }

    private static void dataSelect(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        Department department = em.find(Department.class, 2L);

        System.out.println("검색된 부서 = " + department.getName());
        System.out.println("부서에 소속된 직원 명단");
        for(Employee employee : department.getEmployeeList()) {
            System.out.println(employee.getName() + "(" + employee.getDept().getName() + ")");
        }

    }

    private static void dataUpdate(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // 신규 부서등록
        Department department = new Department();
        department.setName("영업부");
        em.persist(department);

        // 부서 변경
        Employee employee = em.find(Employee.class, 1L);
        employee.setDept(department);
        em.getTransaction().commit();
    }

    private static void dataDelete(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        // 부서 검색
        Department department = em.find(Department.class, 2L);

//        List<Employee> employeeList = department.getEmployeeList();
//        for (Employee employee : employeeList) {
//            em.remove(employee);
//        }

        em.remove(department);
        em.close();



        em.getTransaction().commit();
    }
}
