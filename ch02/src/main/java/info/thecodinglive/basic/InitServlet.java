package info.thecodinglive.basic;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name = "initServlet", urlPatterns = {"/init"}, initParams = {@WebInitParam(name = "siteName", value = "jpub")})
public class InitServlet extends HttpServlet{
    private String myParam = "";

    public void init(ServletConfig servletConfig) throws ServletException{
        this.myParam = servletConfig.getInitParameter("siteName");

        System.out.println("입력받은 사이트 명은" + myParam + "입니다.");
    }
}
