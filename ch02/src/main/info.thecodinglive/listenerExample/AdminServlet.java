package listenerExample;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2015-07-16.
 */
@WebServlet("/admin")
public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Admin admin1 = (Admin)getServletContext().getAttribute("admin1");
        Admin admin2 = (Admin)getServletContext().getAttribute("admin2");

        out.println("관리자1" + admin1.getName() + "," + admin1.getEmail());

        out.println("관리자2" + admin2.getName() + "," + admin2.getEmail());
    }
}
