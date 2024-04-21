package com.example.tdd.order;

import com.example.tdd.discount.DiscountPolicy;
import com.example.tdd.discount.FixDiscountPolicy;
import com.example.tdd.member.MemberRepository;
import com.example.tdd.member.MemberService;
import com.example.tdd.member.MemberServiceImpl;
import com.example.tdd.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
