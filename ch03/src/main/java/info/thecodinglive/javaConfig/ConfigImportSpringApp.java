package info.thecodinglive.javaConfig;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

@Import(BeanConfig.class)
public class ConfigImportSpringApp {
    public static void main(String ar[]) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                BeanConfig.class
        );

        WorkService yourWorkService = context.getBean("yourWorkService", WorkService.class);
        yourWorkService.askWork();

        WorkService myWorkService = context.getBean("myWorkService", WorkService.class);
        myWorkService.askWork();

        context.close();
    }
}
