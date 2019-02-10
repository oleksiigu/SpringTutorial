package hellospringboot.Lesson002WebRest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Transactional // cleanup db after each test
public class IntegrationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private UsersRepository usersRepo;

    @Test
    public void whenNoUsersThenGetUsersRequestShouldReturnEmptyList() throws Exception {
        mvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"))
        ;
    }

    @Test
    public void whenUsersEsistThenGetUsersRequestShoudReturnThem() throws Exception {
        usersRepo.saveAll(Arrays.asList(
                new WebsiteUser("user1", "email1"),
                new WebsiteUser("user2", "email2")
        ));
        mvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name").value("user1"))
                .andExpect(jsonPath("$[0].email").value("email1"))
                .andExpect(jsonPath("$[1].name").value("user2"))
                .andExpect(jsonPath("$[1].email").value("email2"))
        ;
    }

    @Test
    public void whenWeSendRequestToCreateUserThenUserShouldBeSavedToDB() throws Exception {
        assertThat(usersRepo.findAll().size()).isEqualTo(0);
        mvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"userNew\", \"email\": \"emailNew\"}")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("userNew"))
                .andExpect(jsonPath("$.email").value("emailNew"))
        ;
    }
}

