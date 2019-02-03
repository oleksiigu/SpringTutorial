package hellospring.lesson004;

import org.springframework.stereotype.Component;

@Component
class ConsoleWriterWithPrefix extends ConsoleWriter {
    public void write(String msg) {
        super.write(">>>: "+msg);
    }
}
