package serviceTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import info.thecodinglive.service.UserService;

public class UserServiceTest extends ServiceTestConfig {
    @Autowired
    UserService userService;

    @Test
    public void findUserList(){
        userService.findAllUserInfo();
    }

    @Test
    public void findUserNameTest(){
        String uname = "kim1";
        System.out.println(userService.findByOneUserName(uname));
    }
}
