package info.thecodinglive.javaconfig;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotSame;

public class BeanScopeModifierTest {
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
	void afterBeanScopeModifer() {
		Boss boss = context.getBean("boss", Boss.class);
		Boss boss2 = context.getBean("boss", Boss.class);

		assertNotSame(boss, boss2);
	}
}
