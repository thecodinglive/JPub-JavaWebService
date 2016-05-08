import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet(name="Init", urlPatterns={"/init"},
        initParams={ @WebInitParam(name="siteName", value="jpub") } )
public class InitParamServlet extends HttpServlet{
    private String myParam = "";
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.myParam = servletConfig.getInitParameter("siteName ");
        System.out.println("입력받은 사이트명은" + myParam + "입니다.");
    }

}
