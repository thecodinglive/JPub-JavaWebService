package info.thecodinglive.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/session")
public class DefaultSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>세션</title></head><body>");
        HttpSession session = req.getSession();
        out.println("sessionId::" + session.getId() + "<br/>");
        out.println("session created::" + session.getCreationTime() + "<br/>");
        out.println("session lastAccessTime" + session.getLastAccessedTime() + "<br/>");
        out.println("</body></html>");
    }
}
