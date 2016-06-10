package info.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
/*
@ComponentScan(basePackages = "info.thecodinglive.controller")
@Configuration
@EnableAutoConfiguration
*/
@SpringBootApplication
public class RestApp {
    public static void main(String[] ar){
        SpringApplication.run(RestApp.class, ar);
    }
}
