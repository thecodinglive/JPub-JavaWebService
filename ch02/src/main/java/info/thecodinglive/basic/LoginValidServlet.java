package info.thecodinglive.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.function.Predicate;

@WebServlet(name = "LoginValidServlet", urlPatterns = {"/postsendstatus"})
public class LoginValidServlet extends HttpServlet {
    private static final String originPwd = "073";
    private static final Predicate<String> pwdVerifyer = pwd -> pwd != null && pwd.equals(originPwd);
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

        if (pwdVerifyer.test(pwd)) {
            writer.println("전달받은 이름은" + user + "이고" + "<br/>" + "비밀번호는" + pwd + "입니다.");
        } else {
            resp.setStatus(400);
        }

        writer.println("</body>");
        writer.println("</html>");
    }
}
