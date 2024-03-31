package info.thecodinglive.handlermapping.requestmapping;


import org.junit.jupiter.api.Test;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CustomGetTest {
	@Test
	public void testCustomGetMappingTest() throws Exception {
		CustomRequestMappingHandlerMapping handlerMapping = new CustomRequestMappingHandlerMapping();

		Optional<RequestMappingInfo> optionalRequestMappingInfo = Arrays.stream(CustomGetMock.class.getDeclaredMethods())
			.filter(method -> method.isAnnotationPresent(CustomGet.class))
			.map(method -> handlerMapping.getMappingForMethod(method, CustomGetMock.class))
			.findFirst();

		assertTrue(optionalRequestMappingInfo.isPresent(), "RequestMappingInfo not null");
		assertTrue(optionalRequestMappingInfo.get().getPatternsCondition().getPatterns().contains("/custom"),
			"어노테이션에 등록된 path 정보");
	}
}
