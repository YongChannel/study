package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    //ApplicationContext: 스프링 컨테이너이자 인터페이스
    //AnnotationConfigApplicationContext(AppConfig.class): 인터페이스 구현체, 구성 정보로 AppConfig.class 지정
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean() {
        //ac.getBeanDefinitionNames(): 스프링 빈에 등록된 모든 빈 이름을 조회
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            //ac.getBean(빈이름, 타입) or (빈이름): 빈 이름으로 빈 객체 조회
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("Name = " + beanDefinitionName + ", Object = " + bean);

        }

    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findApplicationBean() {
        //ac.getBeanDefinitionNames(): 스프링 빈에 등록된 모든 빈 이름을 조회
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            //ac.getBeanDefinition(): 스프링 빈에 등록된 빈 하나하나 이름을 조회
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);

            //getRole(): 사용하는 빈 구분
            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                //ac.getBean(빈이름, 타입) or (빈이름): 빈 이름으로 빈 객체 조회
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("Name = " + beanDefinitionName + ", Object = " + bean);

            }

        }

    }

}
