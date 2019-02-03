package hellospring.lesson009jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// https://docs.spring.io/spring-data/jpa/docs/1.3.0.RELEASE/reference/html/jpa.repositories.html

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByFirstNameLike(String firstName);
    List<Person> findByFirstNameLikeAndLastNameLike(String firstName, String lastName);
    List<Person> findByOrderByFirstNameDesc();

    @Query("select p from Person p where p.firstName = ?1")
    List<Person> findCustom(String firstName);
}
