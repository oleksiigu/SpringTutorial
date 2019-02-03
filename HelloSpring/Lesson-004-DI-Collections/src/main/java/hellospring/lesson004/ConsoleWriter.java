package hellospring.lesson004;

import org.springframework.stereotype.Component;

@Component
class ConsoleWriter implements AbstractWriter {
    public void write(String msg) {
        System.out.println(msg);
    }
}
