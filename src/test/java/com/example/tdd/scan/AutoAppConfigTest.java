package com.example.tdd.scan;

import com.example.tdd.member.MemberRepository;
import com.example.tdd.member.MemberService;
import com.example.tdd.AutoAppConfig;
import com.example.tdd.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();
        Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

}
