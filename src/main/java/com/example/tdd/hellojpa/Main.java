package com.example.tdd.hellojpa;

import com.example.tdd.hellojpa.entity.Member;
import com.example.tdd.hellojpa.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 팀 저장
            Team team = new Team();
            team.setName("TeamA");
            em.persist(team);

            // 회원 저장
            Member member = new Member();
            member.setName("member1");
            member.setTeamId(team.getId());
            em.persist(member);

            tx.commit();
            em.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
