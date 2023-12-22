package info.thecodinglive;

import org.springdoc.core.configuration.SpringDocConfiguration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import info.thecodinglive.config.OpenApiConfig;

@SpringBootApplication
@Import({SpringDocConfiguration.class, OpenApiConfig.class})
public class RestApp implements CommandLineRunner {
        public static void main(String[] args) {
            SpringApplication.run(RestApp.class, args);
        }

        @Override
        public void run(String... args) throws Exception {

        }
}
