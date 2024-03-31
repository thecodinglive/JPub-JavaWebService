package info.thecodinglive.javaconfig;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DBConfigLoadTest {
	AnnotationConfigApplicationContext context;

	@BeforeEach
	void contextSetup() {
		context = new AnnotationConfigApplicationContext();
		context.register(DBConfig.class);
		context.refresh();
	}

	@AfterEach
	void closeContext() {
		context.close();
	}

	@Test
	public void dbConfigBeanTest() {
		DBConnectionConfig connectionConfig = context.getBean(DBConnectionConfig.class);
		assertNotNull(connectionConfig, "빈은 null이 되면 안됨");
		assertEquals("jdbc:mysql://localhost:3306/mydb", connectionConfig.getUrl());
		assertEquals("com.mysql.cj.jdbc.Driver", connectionConfig.getDriverName());
		assertEquals(3306, connectionConfig.getPort());
	}
}
