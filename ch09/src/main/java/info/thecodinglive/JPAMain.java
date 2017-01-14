package info.thecodinglive;

import info.thecodinglive.model.UserEntity;
import info.thecodinglive.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

//import org.springframework.boot.context.web.SpringBootServletInitializer;

@SpringBootApplication
public class JPAMain extends SpringBootServletInitializer {

        /*
        * Spring boot 1.4버전에서는 context.web 패키지 하위에 SpringBootServletInitializer는 deprecated 되었다.
        * 1.4버전부터는 web.support 패키지를 참조하도록 해야 한다.
        * */
        @Override
        protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
                return builder.sources(JPAMain.class);
        }

        public static void main(String[] args) {
                ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
                UserRepository userRepository = context.getBean(UserRepository.class);

                userRepository.save(new UserEntity("홍길동"));
                userRepository.save(new UserEntity("강감찬"));
                userRepository.save(new UserEntity("척준경"));

        }
}
