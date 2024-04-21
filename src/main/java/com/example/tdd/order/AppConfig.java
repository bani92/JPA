package com.example.tdd.order;

import com.example.tdd.discount.FixDiscountPolicy;
import com.example.tdd.member.MemberRepository;
import com.example.tdd.member.MemberService;
import com.example.tdd.member.MemberServiceImpl;
import com.example.tdd.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
