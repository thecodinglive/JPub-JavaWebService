package info.thecodinglive.javaConfig;

import basic.Employee;
import basic.WorkManager;
import basic.WorkService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigSpringApp {
    @Bean
    public WorkManager employee(){
        return new Employee();
    }

    @Bean
    public WorkService javaWorkService(){
        WorkService workService = new WorkService();
        workService.setWorkManager(employee());

        return workService;
    }

    public static void main(String ar[]){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                JavaConfigSpringApp.class
        );

        //workService 메소드명
        WorkService workService = context.getBean("javaWorkService", WorkService.class);
        workService.askWork();
        context.close();
    }



}
