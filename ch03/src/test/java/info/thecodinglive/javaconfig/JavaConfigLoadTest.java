package info.thecodinglive.javaconfig;

import info.thecodinglive.javaConfig.BeanConfig;
import info.thecodinglive.javaConfig.WorkService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class JavaConfigLoadTest {
    AnnotationConfigApplicationContext context;
    @BeforeEach
    void contextSetup() {
        context = new AnnotationConfigApplicationContext();
        context.register(BeanConfig.class);
        context.refresh();
    }
    @AfterEach
    void closeContext() {
        context.close();
    }
    @Test
    void loadJavaConfigBean() {
        WorkService yourWorkService = context.getBean("yourWorkService", WorkService.class);
        yourWorkService.askWork();
        WorkService myWorkService = context.getBean("myWorkService", WorkService.class);
        myWorkService.askWork();

        Assertions.assertNotNull(yourWorkService);
        Assertions.assertNotNull(myWorkService);
    }
}
