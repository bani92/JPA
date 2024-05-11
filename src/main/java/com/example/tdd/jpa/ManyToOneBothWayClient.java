package com.example.tdd.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ManyToOneBothWayClient {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Chapter04");

        try {
            dataInsert(emf);
            dataSelect(emf);

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
        employee.setMemberType(MemberType.USER);
        em.persist(employee);

        Employee employee2 = new Employee();
        employee2.setName("도우너");
        employee2.setDept(department);
        employee.setMemberType(MemberType.ADMIN);
        em.persist(employee2);

        em.getTransaction().commit();
        em.close();
    }

    private static void dataSelect(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        Department department = em.find(Department.class, 1L);

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

        Employee employee = em.find(Employee.class, 1L);
        employee.setDept(null);
        Employee employee2 = em.find(Employee.class, 2L);
        employee2.setDept(null);

        Department department = em.find(Department.class, 1L);
        em.remove(department);
        em.getTransaction().commit();
    }
}
