package info.thecodinglive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringApp {
    public static void main(String ar[])
    {
        SpringApplication.run(SpringApp.class);
    }

@Bean
public CommandLineRunner runner() {
    return (a) -> {
        System.out.println("runnable jar running");
        };
    }
}
