package com.example.tdd.hellojpa;

import com.example.tdd.hellojpa.entity.Member;
import com.example.tdd.hellojpa.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

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
       //     member.setTeam(team);
            em.persist(member);

            team.getMembers().add(member);

            tx.commit();
            em.clear();

//            Member findMember = em.find(Member.class, member.getId());
//            Team findTeam = findMember.getTeam();
//
//            List<Member> members = findTeam.getMembers();
//
//            for (Member member1 : members) {
//                System.out.println("member1 = " + member1);
//            }
//
//            Team findTeam2 = em.find(Team.class, team.getId());
//            int size = findTeam2.getMembers().size();
//            System.out.println("size = " + size);


            em.close();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
