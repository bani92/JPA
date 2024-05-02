package com.example.tdd.order;

import com.example.tdd.discount.DiscountPolicy;
import com.example.tdd.discount.FixDiscountPolicy;
import com.example.tdd.discount.RateDiscountPolicy;
import com.example.tdd.member.MemberRepository;
import com.example.tdd.member.MemberService;
import com.example.tdd.member.MemberServiceImpl;
import com.example.tdd.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
