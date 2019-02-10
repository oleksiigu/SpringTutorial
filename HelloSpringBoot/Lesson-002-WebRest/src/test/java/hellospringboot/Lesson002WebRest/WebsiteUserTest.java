package hellospringboot.Lesson002WebRest;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WebsiteUserTest {

    @Test
    public void testFrom() {
        WebsiteUser user = WebsiteUser.from(new NewUserDTO("testName", "test@test.com"));
        assertThat(user.getName()).isEqualTo("testName") ;
        assertThat(user.getEmail()).isEqualTo("test@test.com") ;
    }

    @Test
    public void testId() {
        WebsiteUser user = new WebsiteUser();
        user.setId(12345);
        assertThat(user.getId()).isEqualTo(12345);
    }

    @Test
    public void testName() {
        WebsiteUser user = new WebsiteUser();
        user.setName("testName");
        assertThat(user.getName()).isEqualTo("testName");
    }

    @Test
    public void testEmail() {
        WebsiteUser user = new WebsiteUser();
        user.setEmail("test@test.com");
        assertThat(user.getEmail()).isEqualTo("test@test.com");
    }
}