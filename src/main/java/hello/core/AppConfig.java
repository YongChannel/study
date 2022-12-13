package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//AppConfig에 설정 구성
@Configuration
public class AppConfig {
    //관심사 분리, 생성자 주입
    //public MemberService memberService() {
    //    return new MemberServiceImpl(new MemoryMemberRepository());
    //}

    //public OrderService orderService() {
    //    return new OrderServiceImpl(new MemoryMemberRepository(), new RateDiscountPolicy());
    //}

    //AppConfig 리펙터링
    //스프링 컨테이너에 스프링 빈 등록
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
