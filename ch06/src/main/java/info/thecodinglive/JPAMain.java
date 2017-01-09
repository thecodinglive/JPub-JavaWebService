package info.thecodinglive;

import info.thecodinglive.model.UserEntity;
import info.thecodinglive.model.UserRole;
import info.thecodinglive.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class JPAMain {


        public static void main(String[] args) {
                ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
                UserRepository userRepository = context.getBean(UserRepository.class);




                userRepository.save( new UserEntity("홍길동",  33,  UserRole.USER));
                userRepository.save( new UserEntity("홍연희",  33,  UserRole.USER));
                userRepository.save( new UserEntity("이홍련",  33,  UserRole.USER));
                userRepository.save( new UserEntity("차미홍",  33,  UserRole.USER));
                userRepository.save( new UserEntity("철수",    24,  UserRole.USER));
                userRepository.save(new UserEntity("영희", 7, UserRole.USER));
                userRepository.save(new UserEntity("척준경", 41, UserRole.ADMIN));
                userRepository.save(new UserEntity("데니스", 80, UserRole.ADMIN));
                userRepository.save(new UserEntity("비숍", 10, UserRole.ADMIN));
                userRepository.save(new UserEntity("헬싱", 600, UserRole.ADMIN));


                UserEntity user = userRepository.findByName("헬싱");
                System.out.println("나이:" + user.getAge() + ","+ "이름:"+ user.getName() + "," +"생성일:"+ user.getCreatedAt());

                List<UserEntity> resultList  = new ArrayList<>();

                //Page<UserEntity> userEntities =  userRepository.findAdmin(UserRole.ADMIN);

                resultList = userRepository.findAllLike("%홍%");

                for(int i=0; i<=resultList.size()-1; i++){
                        System.out.println(resultList.get(i).getName());

                       // System.out.println("관리자:" + userEntities.getContent().get(i).getName());
                }

                System.out.println("maxAge:" + userRepository.maxAge());
                System.out.println("minAge:" + userRepository.minAge());

                //userEntities.forEach(userEntity -> System.out.println(userEntity));



        }
}
