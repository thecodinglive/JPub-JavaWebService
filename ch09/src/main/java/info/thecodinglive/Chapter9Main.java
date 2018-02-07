package info.thecodinglive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.StandardEnvironment;

@EnableAspectJAutoProxy
@SpringBootApplication
public class Chapter9Main implements CommandLineRunner{
       public static void main(String[] args) {
                SpringApplication.run(Chapter9Main.class, args);
        }

    @Override
    public void run(String... args) throws Exception {
    }
}
