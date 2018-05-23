package info.thecodinglive;

import info.thecodinglive.model.UserVO;
import info.thecodinglive.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;

/**
 * references
 *  http://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html
 */

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class MariaDBMain implements CommandLineRunner{

       public static void main(String[] args) {
                SpringApplication.run(MariaDBMain.class, args);
        }

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(userRepository.getUserInfoAll().toString());

        System.out.println("==입력 후==");

        UserVO userEntity = new UserVO("test4", "jpub", "qwer1234");
        userRepository.adduserInfo(userEntity);

        System.out.println(userRepository.getUserInfoAll().toString());

        System.out.println("like 이름 검색");
        System.out.println(userRepository.findByUserNameLike("ki").toString());

        System.out.println("단 건 조회");
        UserVO userVO = userRepository.findByUserName("jpub");
        System.out.println(userVO.getId() +"," +  userVO.getPassword() + "," + userVO.getUserName());
    }
}
