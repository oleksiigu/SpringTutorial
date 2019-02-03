package hellospring.lesson003;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
class DerivedBean extends HelloBean {

    @PostConstruct
    void run() {
        writer.write("DerivedBean: run");
    }
}
