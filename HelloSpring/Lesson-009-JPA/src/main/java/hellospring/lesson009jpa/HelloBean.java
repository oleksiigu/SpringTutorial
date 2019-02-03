package hellospring.lesson009jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

@Component
class HelloBean {

    @Autowired
    private PersonRepository repo;

    @Transactional
    public void run() {
        repo.save(new Person("James", "Smith"));
        repo.save(new Person("George", "Williams"));
        repo.save(new Person("Joseph", "Wilson"));

        printAll();

        printList("Ordered", repo.findByOrderByFirstNameDesc());

        printList("By First Name", repo.findByFirstNameLike("J%"));
        printList("By First/Last Name",
                repo.findByFirstNameLikeAndLastNameLike("J%", "W%"));

        printList("Custom query", repo.findCustom("Joseph"));

        repo.deleteById(2L);
        printAll();

        Person p = repo.getOne(1L);
        p.setFirstName("David");
        repo.save(p);
        printAll();

   }

   private void printList(String msg, List<Person> list) {
       System.out.println(String.format("\n%s:", msg));
       list.forEach(c -> System.out.println(c.toString()));
   }

    private void printAll() {
        printList("All persons", repo.findAll());
    }
}
