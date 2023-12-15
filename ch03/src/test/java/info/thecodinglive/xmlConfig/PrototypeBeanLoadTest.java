package info.thecodinglive.xmlConfig;

import basic.PrototypeBean;
import basic.SingletonBean;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PrototypeBeanLoadTest {
    @Test
    void prototypeBeanLoad() {
        ApplicationContext context = new ClassPathXmlApplicationContext("prototypeContext.xml");

        SingletonBean singletonBean = context.getBean("singletonBean",SingletonBean.class);
        PrototypeBean bean1 = singletonBean.getPrototypeBean();
        PrototypeBean bean2 = singletonBean.getPrototypeBean();

        SingletonBean singletonBean2 = context.getBean("singletonBean", SingletonBean.class);

        assertNotEquals(bean1, bean2);
        assertEquals(singletonBean, singletonBean2);
    }

}
