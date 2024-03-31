package info.thecodinglive.xmlconfig;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class PrototypeBeanLoadTest {
	@Test
	void prototypeBeanLoad() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:prototypeBeanContext.xml");
		SingletoneBean singletoneBean = context.getBean("singletonBean", SingletoneBean.class);
		SingletoneBean singletoneBean2 = context.getBean("singletonBean", SingletoneBean.class);
		PrototypeBean bean1 = singletoneBean.getPrototypeBean();
		PrototypeBean bean2 = singletoneBean.getPrototypeBean();

		assertNotEquals(bean1, bean2);
		assertEquals(singletoneBean, singletoneBean2);

	}
}
