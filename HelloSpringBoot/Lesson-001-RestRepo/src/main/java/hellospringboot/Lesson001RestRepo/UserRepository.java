package hellospringboot.Lesson001RestRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

// Hypermedia As The Engine Of Application State (HATEOAS)
// https://en.wikipedia.org/wiki/HATEOAS

@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<WebsiteUser, Long> {
    List<WebsiteUser> findByName(@Param("name") String name);
    List<WebsiteUser> findByEmailLike(@Param("email") String email);
}