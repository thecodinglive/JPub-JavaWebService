package daoTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import info.thecodinglive.model.UserVO;
import info.thecodinglive.repository.UserRepository;

import static org.mockito.BDDMockito.given;

public class UserDaoTest extends MybatisTestConfig {
    @Autowired
    private UserRepository userRepository;


    @Test
    public void testList(){
        System.out.println(userRepository.getUserInfoAll());
    }

    @Test
    public void createUser(){
        UserVO userVO = new UserVO();
        userVO.setId("jpub115");
        userVO.setUserName("홍길동");
        userVO.setEmail("test4@jpub.com");
        userRepository.adduserInfo(userVO);
        System.out.println(userRepository.getUserInfoAll());
    }
}
