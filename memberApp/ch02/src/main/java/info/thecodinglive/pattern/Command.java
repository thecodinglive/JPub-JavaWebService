package info.thecodinglive.pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Command {
    private HttpServletRequest req;
    private HttpServletResponse res;
    private ServletContext servletContext;

    abstract public void execute();

    public void forward(String url){
        try{
            RequestDispatcher rd = req.getRequestDispatcher(url);
            rd.forward(getReq(), getRes());
        }catch (IOException ioe){
            servletContext.log("forward Error",ioe);
        }catch (ServletException servletEx){
            servletContext.log("servlet Error", servletEx);
        }
    }

    public HttpServletRequest getReq() {
        return req;
    }

    public void setReq(HttpServletRequest req) {
        this.req = req;
    }

    public HttpServletResponse getRes() {
        return res;
    }

    public void setRes(HttpServletResponse res) {
        this.res = res;
    }

    public ServletContext getServletContext() {
        return servletContext;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}
