package info.thecodinglive.handlermapping.simpleurlhandlermapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.HttpRequestHandler;

import java.io.IOException;

public class SimpleMappingController implements HttpRequestHandler {
	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().write("simple Home Page");
	}
}
