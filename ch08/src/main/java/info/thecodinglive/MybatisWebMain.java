package info.thecodinglive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class MybatisWebMain extends SpringBootServletInitializer implements CommandLineRunner{
       public static void main(String[] args) {
                SpringApplication.run(MybatisWebMain.class, args);
        }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MybatisWebMain.class);
    }

    @Override
    public void run(String... args) throws Exception {
    }
}
