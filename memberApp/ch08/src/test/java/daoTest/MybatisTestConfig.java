package daoTest;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import info.thecodinglive.config.MyBatisConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MyBatisConfig.class, loader = AnnotationConfigContextLoader.class)
@Rollback
public class MybatisTestConfig {
}
