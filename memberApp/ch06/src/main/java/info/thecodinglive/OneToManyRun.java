package info.thecodinglive;

import info.thecodinglive.service.SchoolService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OneToManyRun {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
        SchoolService schoolService = context.getBean(SchoolService.class);
        schoolService.findSchoolInfo();
    }
}
