package hellospring.lesson006;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;
import java.util.function.Consumer;

@Component
class AsyncBean {

    @Async
    public void doAsync() {
        print("doAsync: enter");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            print("doAsync: interrupted");
        }
        print("doAsync: exit");
    }

    @Async
    public void doAsyncWithParams(String msg, Consumer<String> consumer) {
        print("doAsyncWithParams: enter msg="+msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            print("doAsyncWithParams: interrupted");
        }
        consumer.accept("Result");
        print("doAsyncWithParams: exit");
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
        System.out.println(String.format("AsyncBean: %s [%s] %s"
                , msg
                , Thread.currentThread().getName()
                , new Date().toString())
        );
    }

}
