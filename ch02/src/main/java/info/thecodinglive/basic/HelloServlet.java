package info.thecodinglive.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/helloget"})
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet 메소드 호출");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        resp.setContentType("text/html");
        writer.println("<html>");
        writer.println("<head><title>jpub java webservice</title></head>");
        writer.println("<body> get 요청 예제입니다. </body>");
        writer.println("</html>");
    }
}
