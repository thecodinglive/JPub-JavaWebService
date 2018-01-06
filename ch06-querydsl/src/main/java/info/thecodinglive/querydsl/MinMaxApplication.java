package info.thecodinglive.querydsl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MinMaxApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(MinMaxApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

        UserEntity u = new UserEntity("나라", 26, UserRole.USER);
        UserEntity u1 = new UserEntity("민하", 26, UserRole.USER);
        UserEntity u2 = new UserEntity("경리", 28, UserRole.USER);
        UserEntity u3 = new UserEntity("서지혜", 34, UserRole.USER);

        userRepository.save(u);
        userRepository.save(u1);
        userRepository.save(u2);
        userRepository.save(u3);

        System.out.println(userRepository.maxAge());
        System.out.println(userRepository.minAge());

    }
}
