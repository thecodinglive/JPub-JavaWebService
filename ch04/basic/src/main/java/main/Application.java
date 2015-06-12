package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
@ComponentScan(basePackages = "info.thecodinglive.controller")
@Configuration
@EnableAutoConfiguration
public class Application {
    public static void main(String[] ar){
        ApplicationContext ctx =  SpringApplication.run(Application.class, ar);

        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
    }
}
