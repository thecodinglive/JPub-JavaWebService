package info.thecodinglive.pattern;

public class HomeView extends Command {
    @Override
    public void execute() {
        forward("/home.jsp");
    }
}
