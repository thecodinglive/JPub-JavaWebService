package info.thecodinglive.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/session/read")
public class ReadSessionValueServlet extends HttpServlet {
    private static final String SESSION_NAME = "jpub";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>세션</title></head><body>");

        HttpSession session = req.getSession();
        String sessionValue = (String) session.getAttribute(SESSION_NAME);
        out.println("생성된 세션 값:" + sessionValue);
        out.println("</body></html>");
    }
}

