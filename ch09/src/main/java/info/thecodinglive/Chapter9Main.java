package info.thecodinglive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class Chapter9Main extends SpringBootServletInitializer implements CommandLineRunner{
       public static void main(String[] args) {
                SpringApplication.run(Chapter9Main.class, args);
        }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Chapter9Main.class);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
