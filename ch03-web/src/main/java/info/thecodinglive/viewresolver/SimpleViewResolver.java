package info.thecodinglive.viewresolver;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class SimpleViewResolver {
	private static String VIEW_PATH_PREFIX = "/WEB-INF/views/";

	public void resolveView(String viewName, ServletRequest request, ServletResponse response) throws Exception {
		RequestDispatcher dispatcher = request.getRequestDispatcher(VIEW_PATH_PREFIX + viewName + ".jsp");
		dispatcher.forward(request, response);
	}
}
