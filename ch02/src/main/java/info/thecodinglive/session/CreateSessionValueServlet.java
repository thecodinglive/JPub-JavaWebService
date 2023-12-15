package info.thecodinglive.session;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/createse")
public class CreateSessionValueServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>세션</title></head><body>");

        HttpSession session = req.getSession();
        session.setAttribute("jpub", "book");
        out.println("세션이 생성되었습니다.");
        out.println("<a href='/readse'>세션 읽기</a></body></html>");
    }
}

