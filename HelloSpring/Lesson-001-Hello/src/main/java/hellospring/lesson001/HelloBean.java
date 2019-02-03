package hellospring.lesson001;

import org.springframework.stereotype.Component;

@Component
class HelloBean {
    public void helloWorld() {
        System.out.println("Hello Spring!");
    }
}
