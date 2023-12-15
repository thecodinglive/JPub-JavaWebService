package info.thecodinglive.init;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name="Init-param", urlPatterns={"/init-param"},
        initParams={ @WebInitParam(name="siteName", value="jpub") } )
public class InitParamServlet extends HttpServlet {
    private String myParam = "";
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.myParam = servletConfig.getInitParameter("siteName ");
        System.out.println("입력받은 사이트명은" + myParam + "입니다.");
    }
}
