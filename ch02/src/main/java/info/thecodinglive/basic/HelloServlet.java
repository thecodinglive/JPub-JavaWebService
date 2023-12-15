package info.thecodinglive.basic;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloServlet", urlPatterns = {"/helloget"})
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet 메소드 호출");
        System.out.println("프로토콜: " + req.getProtocol());
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        String today = req.getParameter("today");

        resp.setContentType("text/html");
        writer.println("<html>");
        writer.println("<head><title>get요청 예제</title></head>");
        writer.println("<body>" + today + " 쉬면 내일은 뛰어야 한다.");
        writer.println("</body>");
        writer.println("</html>");
    }
}
