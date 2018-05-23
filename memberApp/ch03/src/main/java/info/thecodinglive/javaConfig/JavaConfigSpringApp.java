package info.thecodinglive.javaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigSpringApp {
    public static void main(String ar[]){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanConfig.class);
        context.refresh();

        WorkService yourWorkService = context.getBean("yourWorkService", WorkService.class);
        yourWorkService.askWork();

        WorkService myWorkService = context.getBean("myWorkService", WorkService.class);
        myWorkService.askWork();

        context.close();
    }
}
