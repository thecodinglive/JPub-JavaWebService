package info.thecodinglive.handlermapping.requestmapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

public class CustomRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
	@Override
	protected RequestMappingInfo getMappingForMethod(Method method, Class<?> handlerType) {
		CustomGet customGet = method.getAnnotation(CustomGet.class);
		System.out.println("CustomGet path : " + customGet.value());
		if (customGet != null) {
			return RequestMappingInfo
				.paths(customGet.value())
				.methods(RequestMethod.GET)
				.build();

		}
		return super.getMappingForMethod(method, handlerType);
	}
}
