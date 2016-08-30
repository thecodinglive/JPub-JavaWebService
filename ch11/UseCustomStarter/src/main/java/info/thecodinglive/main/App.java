package info.thecodinglive.main;

import info.thecodinglive.service.HelloService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;




@SpringBootApplication
public class App {
    public static void main(String ar[]){
       SpringApplication.run(App.class, ar).getBean(HelloService.class).hi();
    }
}
