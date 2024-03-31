package info.thecodinglive.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class OpenApiDocConfig {
	@Bean
	public OpenAPI metadata() {
		return new OpenAPI()
			.info(new Info().title("JPub Spring Boot Rest Api")
				.description("Spring Boot Rest API")
				.version("2.0"));
	}

	@Bean
	public GroupedOpenApi publicExposeApi() {
		return GroupedOpenApi
			.builder()
			.group("API2")
			.pathsToMatch("/api/**")
			.addOpenApiMethodFilter(method -> method.isAnnotationPresent(Operation.class))
			.build();
	}
}
