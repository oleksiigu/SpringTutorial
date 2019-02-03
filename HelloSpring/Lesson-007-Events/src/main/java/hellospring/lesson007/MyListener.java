package hellospring.lesson007;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Component
class MyListener {

    @EventListener
    public void syncHandleString(String msg) {
        print("syncHandleString "+msg);
    }

    @EventListener
    public void syncHandleInt(int n) {
        print("syncHandleInt "+n);
    }

    @Async
    @EventListener
    public void asyncHandleString(String msg) {
        print("asyncHandleString enter msg="+msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            print("asyncHandleString: interrupted");
        }
        print("asyncHandleString exit msg="+msg);
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
        System.out.println(String.format("MyListener: %s [%s] %s"
                , msg
                , Thread.currentThread().getName()
                , new Date().toString())
        );
    }
}
