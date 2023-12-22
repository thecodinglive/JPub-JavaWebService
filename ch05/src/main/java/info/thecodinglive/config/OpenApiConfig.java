package info.thecodinglive.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;



@Configuration

@Profile({"dev"})
public class OpenApiConfig {

    private OpenAPI metadata() {
        return new OpenAPI()
            .info(new Info().title("JPub Spring Boot")
                .description("Spring Boot Rest API")
                .version("2.0"));
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return  GroupedOpenApi.builder()
                 .group("openApi")
                .pathsToMatch("/basic/.*")
                .build();
    }

}
