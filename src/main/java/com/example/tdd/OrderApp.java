package com.example.tdd;

import com.example.tdd.member.Grade;
import com.example.tdd.member.Member;
import com.example.tdd.member.MemberService;
import com.example.tdd.member.MemberServiceImpl;
import com.example.tdd.order.AppConfig;
import com.example.tdd.order.Order;
import com.example.tdd.order.OrderService;
import com.example.tdd.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
//        MemberService memberService = new MemberServiceImpl();
//        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);

        System.out.println("order = " + order.toString());
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
