package com.example.tdd;

import com.example.tdd.member.Grade;
import com.example.tdd.member.Member;
import com.example.tdd.member.MemberService;
import com.example.tdd.member.MemberServiceImpl;
import com.example.tdd.order.AppConfig;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
