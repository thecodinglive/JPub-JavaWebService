package info.thecodinglive.xmlConfig;

import basic.WorkService;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlSpringApp {
    public static void main(String ar[]){
        GenericXmlApplicationContext context = new GenericXmlApplicationContext(
                "classpath:applicationContext.xml"
        );

        WorkService workService = context.getBean("myWorkService", WorkService.class);
        workService.askWork();

        context.close();
    }
}
