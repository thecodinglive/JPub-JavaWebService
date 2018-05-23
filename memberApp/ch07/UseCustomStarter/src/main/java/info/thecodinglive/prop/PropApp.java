package info.thecodinglive.prop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({MyProperties.class})
public class PropApp {
    public static void main(String ar[]) {
        SpringApplication.run(PropApp.class, ar);
    }

    @Autowired
    MyProperties prop;

    @Bean
    CommandLineRunner values() {
        return ar -> {
            System.out.println("server ip:" + prop.getServerIp());
            System.out.println("app name:" + prop.getName());
        };
    }
}
