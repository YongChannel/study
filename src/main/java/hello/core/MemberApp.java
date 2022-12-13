package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        //MemberService memberService = new MemberServiceImpl();

        //관심사 분리
        //AppConfig appConfig = new AppConfig();
        //MemberService memberService = appConfig.memberService();

        //스프링 전환
        //ApplicationContext: 스프링 컨테이너
        //applicationContext.getBean: 스프링 빈 조회
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println("newMember = " + member.getName());
        System.out.println("findMember = " + findMember.getName());

    }

}
