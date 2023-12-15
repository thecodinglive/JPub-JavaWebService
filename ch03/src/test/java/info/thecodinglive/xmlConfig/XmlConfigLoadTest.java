package info.thecodinglive.xmlConfig;

import basic.WorkService;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class XmlConfigLoadTest {
    @Test
    void applicationContextBeanLoadTest() {
        try (GenericXmlApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml")) {
            WorkService myWorkService = context.getBean("myWorkService", WorkService.class);
            WorkService yourWorkService = context.getBean("yourWorkService", WorkService.class);

            assertNotNull(myWorkService);
            assertNotNull(yourWorkService);

            myWorkService.askWork();
            yourWorkService.askWork();
        }
    }
}
