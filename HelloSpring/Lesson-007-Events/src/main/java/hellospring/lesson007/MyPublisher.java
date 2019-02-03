package hellospring.lesson007;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
class MyPublisher {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void run() {
        System.out.println("MyPublisher: run enter");
        publisher.publishEvent("Hello");
        publisher.publishEvent(123);
        publisher.publishEvent("Bye");
        System.out.println("MyPublisher: run exit");
    }
}
