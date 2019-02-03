package hellospring.lesson007;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.stream.Stream;

@Configuration
@ComponentScan
class App007 {

    public static void main(String[] args) {
        try(AbstractApplicationContext context = new AnnotationConfigApplicationContext(App007.class)) {
            Stream.of(context.getBeanDefinitionNames()).forEach(name -> System.out.println("Bean: "+name));
            // MyPublisher.run method should be called after all beans are initialized
            context.getBean(MyPublisher.class).run();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("Main: interrupted");
            }
        }
    }
}
