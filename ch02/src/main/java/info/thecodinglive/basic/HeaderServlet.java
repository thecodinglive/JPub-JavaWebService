package info.thecodinglive.basic;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/header")
public class HeaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title> header 예제</title></head><body>");
        out.println("<br/>");
        Enumeration headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String name = (String) headerNames.nextElement();
            String value = req.getHeader(name);
            out.println(name + ":" + value + "<br/>");
        }
        out.println("</body></html>");
    }
}
