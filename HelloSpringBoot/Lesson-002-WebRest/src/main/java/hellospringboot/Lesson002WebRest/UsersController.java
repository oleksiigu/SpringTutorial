package hellospringboot.Lesson002WebRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("")
    List<WebsiteUser> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/search/findByName")
    List<WebsiteUser> getUsersByName(String name) {
        return usersService.getUsersByName(name);
    }

    @GetMapping("/search/findByEmailLike")
    List<WebsiteUser> getUsersByEmailLike(String email) {
        return usersService.getUsersByEmailLike(email);
    }

    @GetMapping("/{id}")
    ResponseEntity<WebsiteUser> getUserByIs(@PathVariable("id") long id) {
        return usersService.getUser(id)
                .map(u -> new ResponseEntity<>(u, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    WebsiteUser createUser(@RequestBody NewUserDTO user) {
        return usersService.createUser(user);
    }
}
