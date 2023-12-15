package info.thecodinglive.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;

/**
 * Created by ysj on 2017-11-15.
 */
@WebServlet(name = "HelloServlet2", urlPatterns = {"/hellopost"})
public class HelloServlet2 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost 호출");
    }
}
