package info.thecodinglive.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookier")
public class CookieReadServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		Cookie[] cookies = req.getCookies();
		String cookieValue = "";
		for (Cookie cookie : cookies) {
			if ("test".equals(cookie.getName())) {
				cookieValue = cookie.getValue();
			}
		}
		writer.print("cookieValue::" + cookieValue);
	}
}
