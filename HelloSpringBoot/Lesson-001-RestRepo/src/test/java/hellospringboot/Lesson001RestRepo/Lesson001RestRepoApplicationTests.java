package hellospringboot.Lesson001RestRepo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Lesson001RestRepoApplicationTests {

    @Autowired
    UserRepository usersRepo;

    @Test
    public void searchUsersByName() {
        usersRepo.save(new WebsiteUser("testUser", "user@test.com"));
        List<WebsiteUser> res = usersRepo.findByName("testUser");
        assertThat(res).isNotNull();
        assertThat(res.size()).isEqualTo(1);
        WebsiteUser user = res.get(0);
        assertThat(user.getName()).isEqualTo("testUser");
        assertThat(user.getEmail()).isEqualTo("user@test.com");
    }

    @Test
    public void searchUsersByEmail() {
        usersRepo.save(new WebsiteUser("testUser", "user@test.com"));
        List<WebsiteUser> res = usersRepo.findByEmailLike("%test%");
        assertThat(res).isNotNull();
        assertThat(res.size()).isEqualTo(1);
        WebsiteUser user = res.get(0);
        assertThat(user.getName()).isEqualTo("testUser");
        assertThat(user.getEmail()).isEqualTo("user@test.com");
    }
}

