package info.thecodinglive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
@ComponentScan(basePackages = "info.thecodinglive.controller")
@Configuration
@EnableAutoConfiguration
*/
@SpringBootApplication
public class RestApp implements CommandLineRunner {
        public static void main(String[] args) {
            SpringApplication.run(RestApp.class, args);
        }

        @Override
        public void run(String... args) throws Exception {

        }
}
