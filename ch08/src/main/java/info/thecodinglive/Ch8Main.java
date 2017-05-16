package info.thecodinglive;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ch8Main implements CommandLineRunner{
       public static void main(String[] args) {
                SpringApplication.run(Ch8Main.class, args);
        }

    @Override
    public void run(String... args) throws Exception {
    }
}
