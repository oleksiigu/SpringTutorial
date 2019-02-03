package hellospring.lesson002;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
class OutputWriter {

    @PostConstruct
    private void init() {
        write("OutputWriter: init");
    }

    @PreDestroy
    private void destroy() {
        write("OutputWriter: destroy");
    }

    public void write(String msg) {
        System.out.println(msg);
    }
}
