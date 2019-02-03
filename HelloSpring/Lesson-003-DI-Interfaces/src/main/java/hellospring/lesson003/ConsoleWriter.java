package hellospring.lesson003;

import org.springframework.stereotype.Component;

@Component
public class ConsoleWriter implements AbstractWriter {
    public void write(String msg) {
        System.out.println(msg);
    }
}
