package info.thecodinglive.filter;


import javax.servlet.*;
import java.io.IOException;

public class EncodingFilter implements Filter {

    private String reqEncoding = "UTF-8";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingStr = filterConfig.getInitParameter("encoding");
        if (encodingStr != null) {
            reqEncoding = encodingStr;
        }
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding(reqEncoding);
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
