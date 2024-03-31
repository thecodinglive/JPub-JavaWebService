package info.thecodinglive.pattern;

public class HomeView extends Command {
	@Override
	public void execute() {
		forward("/WEB-INF/views/home.jsp");
	}
}
