package info.thecodinglive.cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(urlPatterns = "/modicookie")
public class CookieModifyServlet extends HttpServlet {
    private static final String COOKIE_NAME = "jpub";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals(COOKIE_NAME))
                    .findFirst()
                    .ifPresent(cookie -> {
                        Cookie modifiedCookie = new Cookie(COOKIE_NAME, "read");
                        resp.addCookie(modifiedCookie);
                    });
        }
        resp.sendRedirect("/readcookie");
    }
}
