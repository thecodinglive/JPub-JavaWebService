package info.thecodinglive.viewresolver;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/resolver")
public class ViewResolverServlet extends HttpServlet {
	private SimpleViewResolver viewResolver;

	@Override
	public void init(ServletConfig config) throws ServletException {
		viewResolver = new SimpleViewResolver();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String viewName = "resolver";
			viewResolver.resolveView(viewName, req, resp);
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
