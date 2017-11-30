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
        Cookie jcookie = new Cookie("jpub", "books");
        jcookie.setDomain("thecodinglive.info");
        resp.addCookie(jcookie);
    }

}
