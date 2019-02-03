package hellospring.lesson004;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

@Component
class HelloBean {
    @Autowired
    private AbstractWriter[] writersArray;

    @Autowired
    private List<AbstractWriter> writersList;

    @Autowired
    private Collection<AbstractWriter> writersCollection;

    @PostConstruct
    public void run() {
        Stream.of(writersArray).forEach(w -> w.write("Hello Spring using writers array!"));
        writersList.forEach(w -> w.write("Hello Spring using writers list!"));
        writersCollection.forEach(w -> w.write("Hello Spring using writers collection!"));
    }
}
