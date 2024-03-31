package info.thecodinglive.pattern;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/route")
public class FrontController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
		String cmd = req.getParameter("cmd");
		try {
			Command command = (Command) Class.forName(UrlClassName.findByCommand(cmd).getCommandClass())
				.getDeclaredConstructor().newInstance();
			command.bindUrlProperties(req, resp, getServletContext());
			command.execute();
		} catch (Exception ex) {
			getServletContext().log("class not found", ex);
		}
	}
}
