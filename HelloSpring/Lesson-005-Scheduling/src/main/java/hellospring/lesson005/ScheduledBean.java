package hellospring.lesson005;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Component
class ScheduledBean {

    @Scheduled(initialDelay = 5000, fixedRate = 1000)
    public void sec() {
        print("sec");
    }

    @Scheduled(fixedDelay = 1000)
    public void delay() {
        print("delay enter");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            print("delay interrupted");
        }
        print("delay exit");
    }

    @PostConstruct
    private void init() {
        print("init");
    }

    @PreDestroy
    private void destroy() {
        print("destroy");
    }

    private void print(String msg) {
        System.out.println(String.format("ScheduledBean: %s [%s] %s"
                , msg
                , Thread.currentThread().getName()
                , new Date().toString()
        ));
    }
}
