package hellospring.lesson003;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class HelloBean {
    @Autowired
    AbstractWriter writer;

    @PostConstruct
    public void init() {
        writer.write(getClass().getSimpleName()+": init");
    }
}
