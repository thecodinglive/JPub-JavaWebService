package info.thecodinglive;

import info.thecodinglive.model.FreeBoardVO;
import info.thecodinglive.repository.FreeBoardRepository;
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
public class FreeBoardApp implements CommandLineRunner{
       public static void main(String[] args) {
           SpringApplication.run(FreeBoardApp.class, args);
        }

    @Autowired
    FreeBoardRepository freeBoardRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("frebboard run");
        FreeBoardVO freeBoardVO = new FreeBoardVO();
        freeBoardVO.setUserName("홍길동");
        freeBoardVO.setCategory("101");
        freeBoardVO.setContent("자유게시판 첫 글");
        freeBoardVO.setTitle("안녕");

        freeBoardRepository.registBoard(freeBoardVO);
    }
}
