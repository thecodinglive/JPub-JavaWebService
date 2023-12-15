package info.thecodinglive.cookie;



import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/cookiew")
public class CookieWriteServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter writer = resp.getWriter();

		Cookie testCookie = new Cookie("test", "1234");
		testCookie.setMaxAge(60 * 60 * 24); // 1day
		resp.addCookie(testCookie);

		writer.println("cookie created");
	}
}
