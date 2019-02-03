package hellospring.lesson001;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
class HelloApp {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HelloApp.class);
        HelloBean hello = context.getBean(HelloBean.class);
        hello.helloWorld();
    }
}
