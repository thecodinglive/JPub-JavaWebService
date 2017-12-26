package info.thecodinglive.pattern;

public class WriteView extends Command {
    @Override
    public void execute() {
        forward("/write.jsp");
    }
}
