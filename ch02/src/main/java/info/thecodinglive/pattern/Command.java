package info.thecodinglive.pattern;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public abstract class Command {
	private HttpServletRequest req;
	private HttpServletResponse res;
	private ServletContext servletContext;

	abstract public void execute();

	public void forward(String url) {
		getServletContext().log("url:: " + url);
		try {
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(getReq(), getRes());
		} catch (IOException ioe) {
			servletContext.log("forward Error", ioe);
		} catch (ServletException servletEx) {
			servletContext.log("servlet Error", servletEx);
		}
	}

	public void bindUrlProperties(HttpServletRequest req, HttpServletResponse resp, ServletContext servletContext) {
		this.req = req;
		this.res = resp;
		this.servletContext = servletContext;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public HttpServletResponse getRes() {
		return res;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

}
