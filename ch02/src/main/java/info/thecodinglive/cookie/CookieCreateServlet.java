package info.thecodinglive.cookie;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/newcookie")
public class CookieCreateServlet extends HttpServlet {
    private static final String COOKIE_NAME = "jpub";
    private static final String COOKIE_VALUE = "books";
    private static final int COOKIE_MAX_AGE = 3600;
    @Override
    public void doGet(HttpServletRequest req,
                      HttpServletResponse resp) throws ServletException,
            IOException {
        Cookie jcookie = new Cookie(COOKIE_NAME, COOKIE_VALUE);
        jcookie.setMaxAge(COOKIE_MAX_AGE);
        resp.addCookie(jcookie);

        resp.sendRedirect("/readcookie");
    }
}
