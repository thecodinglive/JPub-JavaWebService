package info.thecodinglive.javaconfig;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BossBeanPostProcessorTest {
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
	void afterBeanPostProcess() {
		Boss boss = context.getBean("boss", Boss.class);
		Assertions.assertNotNull(boss);
	}
}
