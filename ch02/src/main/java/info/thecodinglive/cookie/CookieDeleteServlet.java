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

@WebServlet(urlPatterns = "/delcookie")
public class CookieDeleteServlet extends HttpServlet {
    private static final String COOKIE_NAME = "jpub";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals(COOKIE_NAME))
                    .findFirst()
                    .ifPresent(cookie -> {
                        Cookie deleteCookie = new Cookie(COOKIE_NAME, "");
                        deleteCookie.setMaxAge(0);
                        resp.addCookie(deleteCookie);
                    });
        }
    }
}
