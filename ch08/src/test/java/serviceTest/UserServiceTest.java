package serviceTest;

import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import info.thecodinglive.service.UserService;

public class UserServiceTest extends ServiceTestConfig {
    @MockBean
    UserService userService;

    @Test
    public void findUserList(){
        userService.findAllUserInfo();
    }
}
