package hellospring.lesson008;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

@Configuration
@ComponentScan
class App008 {

    public static void main(String[] args) {
        try(AbstractApplicationContext context = new AnnotationConfigApplicationContext(App008.class)) {
            // HelloBean.run() should be called after all beans are initialized
            // Cache will not work if run it via @PostConstruct
            context.getBean(HelloBean.class).run();
        }
    }
}
