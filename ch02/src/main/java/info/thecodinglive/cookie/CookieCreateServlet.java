package info.thecodinglive.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/newcookie")
public class CookieCreateServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp) throws ServletException,
            IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title> 쿠키 예제</title></head><body>");
        out.println("<br/>");

        Cookie jcookie = new Cookie("jpub", "books");
        jcookie.setMaxAge(3600);
        resp.addCookie(jcookie);
        out.println("<a href='/readcookie'>readcookie</a></body></html>");
    }
}
