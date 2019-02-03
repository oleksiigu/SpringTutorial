package hellospring.lesson009jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan
class HelloJpaApp {

    public static void main(String[] args) {
        try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(HelloJpaApp.class)) {
            context.getBean(HelloBean.class).run();
        }
    }
}
