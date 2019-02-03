package hellospring.lesson002;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
class HelloBean {
    @Autowired
    private OutputWriter writer;

    @PostConstruct
    private void init() {
        writer.write("HelloBean: init");
    }

    @PreDestroy
    private void destroy() {
        writer.write("HelloBean: destroy");
    }
}
