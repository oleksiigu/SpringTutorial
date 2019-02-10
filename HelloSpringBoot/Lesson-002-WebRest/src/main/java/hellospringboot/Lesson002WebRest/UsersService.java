package hellospringboot.Lesson002WebRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
class UsersService {

    @Autowired
    private UsersRepository usersRepo;

    List<WebsiteUser> getAllUsers() {
        return usersRepo.findAll();
    }

    List<WebsiteUser> getUsersByName(String name) {
        return usersRepo.findByName(name);
    }

    List<WebsiteUser> getUsersByEmailLike(String email) {
        return usersRepo.findByEmailLike(String.format("%%%s%%", email));
    }

    Optional<WebsiteUser> getUser(long id) {
        return usersRepo.findById(id);
    }

    WebsiteUser createUser(NewUserDTO user) {
        WebsiteUser wu = WebsiteUser.from(user);
        return usersRepo.save(wu);
    }
}
