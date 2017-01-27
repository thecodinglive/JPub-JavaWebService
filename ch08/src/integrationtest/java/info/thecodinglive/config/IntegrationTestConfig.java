package info.thecodinglive.config;

import info.thecodinglive.MybatisWebMain;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 /**
     * Created by yun_dev1 on 2017-01-23.
     */
    @RunWith(SpringJUnit4ClassRunner.class)
    @SpringApplicationConfiguration(MybatisWebMain.class)
    @ActiveProfiles("test")
    public abstract class IntegrationTestConfig {
    }

