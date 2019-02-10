package hellospringboot.Lesson002WebRest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UsersService.class})
public class UsersServiceTest {

    @Autowired
    UsersService usersService;

    @MockBean
    UsersRepository usersRepo;

    @Test
    public void createUser() {
        Mockito.when(usersRepo.save(Mockito.any(WebsiteUser.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));
        NewUserDTO userDTO = new NewUserDTO("newUser", "newEmail");
        WebsiteUser user = usersService.createUser(userDTO);
        assertThat(user.getName()).isEqualTo("newUser");
        assertThat(user.getEmail()).isEqualTo("newEmail");
        Mockito.verify(usersRepo, Mockito.times(1)).save(Mockito.any());
    }
}