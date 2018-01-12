package daoTest;

import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import info.thecodinglive.model.UserVO;
import info.thecodinglive.repository.UserRepository;

public class UserDaoTest extends MybatisTestConfig {
    @MockBean
    private UserRepository userRepository;


    @Test
    public void testList(){
        userRepository.getUserInfoAll();
    }

    @Test
    public void createUser(){
        UserVO userVO = new UserVO();
        userVO.setId("jpub115");
        userVO.setUserName("홍길동");
        userVO.setEmail("test1@jpub.com");
        userRepository.adduserInfo(userVO);
    }
}
