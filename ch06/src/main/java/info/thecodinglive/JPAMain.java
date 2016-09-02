package info.thecodinglive;

import info.thecodinglive.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JPAMain implements CommandLineRunner {
        public static void main(String[] args) {
            SpringApplication.run(JPAMain.class, args);
        }

        @Override
        public void run(String... args) throws Exception {
                User user1 = new User("홍길동");
                User user2 = new User("이순신");
                User user3 = new User("척준경");
        }
}
