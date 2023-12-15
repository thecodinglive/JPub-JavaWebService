package info.thecodinglive.filter;


import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("*.jsp")
public class FilterEx implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        res.setContentType("text/html");
        res.setCharacterEncoding("UTF-8");
        PrintWriter out = res.getWriter();
        out.println("필터 동작 전");

        HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("JPUB", "filter");
        chain.doFilter(req, response);
        out.println("필터 동작 후");
    }

    @Override
    public void destroy() {

    }
}
