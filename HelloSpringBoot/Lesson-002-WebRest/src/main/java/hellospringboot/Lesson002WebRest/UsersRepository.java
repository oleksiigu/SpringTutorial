package hellospringboot.Lesson002WebRest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<WebsiteUser, Long> {
    List<WebsiteUser> findByName(@Param("name") String name);
    List<WebsiteUser> findByEmailLike(@Param("email") String email);
}