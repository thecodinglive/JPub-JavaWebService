package info.thecodinglive.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "LoginServlet", urlPatterns = {"/postsend"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost 메소드 호출");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();

        resp.setContentType("text/html");

        String user = req.getParameter("user");
        String pwd = req.getParameter("pwd");
        writer.println("<html>");
        writer.println("<head><title>Login Servlet</title></head>");
        writer.println("<body>");
        writer.println("전달받은 이름은" + user + "이고" + "<br/>" + "비밀번호는" + pwd + "입니다.");
        writer.println("</body>");
        writer.println("</html>");
    }
}
