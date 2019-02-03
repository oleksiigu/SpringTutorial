package hellospring.lesson006;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
class HelloBean {

    @Autowired
    private AsyncBean async;

    @PostConstruct
    public void run() {
        print("run enter");
        async.doAsync();
        async.doAsync();
        async.doAsyncWithParams("async1", (result)->print("Async result1: "+result));
        async.doAsyncWithParams("async2", (result)->print("Async result2: "+result));
        print("run exit");
    }

    @PreDestroy
    private void destroy() {
        print("destroy");
    }

    private void print(String msg) {
        System.out.println(String.format("HelloBean: %s [%s]"
                , msg
                , Thread.currentThread().getName()
        ));
    }
}
