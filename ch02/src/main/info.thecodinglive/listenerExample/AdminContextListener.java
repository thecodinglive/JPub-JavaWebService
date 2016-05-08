package listenerExample;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AdminContextListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context 초기화");
        ServletContext context = sce.getServletContext();
        Admin admin1 = new Admin("나관리", "admin@company.com");
        Admin admin2 = new Admin("나땜빵", "tempy@company.com");

        context.setAttribute("admin",  admin1);
        context.setAttribute("admin2", admin2);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("context가 종료되엇습니다.");
    }


}
