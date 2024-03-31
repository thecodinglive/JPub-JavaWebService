package info.thecodinglive.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import info.thecodinglive.config.JacksonConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JacksonTest {
	@Test
	void testIgnoreUnknownProperties() throws Exception {
		String json = "{\"name\":\"Test Object\",\"color\":\"BLUE\",\"unknownProperty\":\"value\"}";

		ObjectMapper objectMapper = new ObjectMapper();
		//objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

		TestObject testObject = objectMapper.readValue(json, TestObject.class);

		assertNotNull(testObject);
		assertEquals("Test Object", testObject.getName());
		assertEquals(ColorEnum.BLUE, testObject.getColor());
	}

	@Test
	void mapperTest() throws Exception {
		String json = "{\"name\":\"Test Object\",\"color\":\"RED\",\"unknownProperty\":\"value\"}";

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(JacksonConfig.class, JacksonTestConfig.class);
		context.refresh();
		ObjectMapper objectMapper = context.getBean(ObjectMapper.class);

		TestObject testObject = objectMapper.readValue(json, TestObject.class);
		assertNotNull(testObject);
		assertEquals(ColorEnum.RED, testObject.getColor());
		System.out.println(testObject.toString());
	}
}
