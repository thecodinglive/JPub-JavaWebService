package asyncExample;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@WebListener
public class ServletWorker implements ServletContextListener{
    private volatile  Thread thread;
    private static final BlockingQueue<AsyncContext> queue = new LinkedBlockingQueue<>();

    public static void add(AsyncContext c){
        queue.add( c );
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context init");
      Runnable r1 = () ->{
        while( true ){
            try{
                Thread.sleep(2000);
                AsyncContext context;
                while ((context = queue.poll()) != null){
                    try{
                       context.setTimeout(2000);
                        ServletResponse response = context.getResponse();
                        response.setContentType("text/plain");
                        PrintWriter out = response.getWriter();
                        out.printf("Thread %s completed the task", Thread.currentThread().getName());
                        out.flush();
                    }catch(Exception e){
                        throw new RuntimeException();
                    }finally {
                        System.out.println("finally");
                        context.complete();
                    }
                }
            }catch (InterruptedException interrupeE){
                return;
            }
        }
      };
        new Thread(r1).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        thread.interrupt();
    }
}
