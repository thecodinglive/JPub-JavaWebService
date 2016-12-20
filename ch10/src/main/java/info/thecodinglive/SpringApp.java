package info.thecodinglive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yun_dev1 on 2016-11-01.
 */
@SpringBootApplication
public class SpringApp {
    public static void main(String ar[])
    {
        SpringApplication.run(SpringApp.class);
    }

    @RequestMapping("/")
    public String index(){
        return "/";
    }

@Bean
public CommandLineRunner runner() {
    return (a) -> {
        System.out.println("runnable jar running");
        };
    }
}
