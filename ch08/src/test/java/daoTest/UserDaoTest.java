package daoTest;

import info.thecodinglive.config.MyBatisConfig;
import info.thecodinglive.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by yun_dev1 on 2017-01-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MyBatisConfig.class, loader = AnnotationConfigContextLoader.class)
public class UserDaoTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testList(){
        userRepository.getUserInfoAll();
    }
}