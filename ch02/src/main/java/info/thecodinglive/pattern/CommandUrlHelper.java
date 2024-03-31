package info.thecodinglive.pattern;

import java.io.InputStream;
import java.util.Properties;

public class CommandUrlHelper {
    private static CommandUrlHelper instance;
    Properties cmdMapping = new Properties();
    private CommandUrlHelper() {}

    public void actionUrlLoader(InputStream inputStream) {
        try (inputStream) {
            cmdMapping.load(inputStream);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public static CommandUrlHelper getInstance() {
        if (instance == null) {
            instance = new CommandUrlHelper();
        }
        return instance;
    }

    public String getCommandClass(String cmd) {
        return cmdMapping.getProperty(cmd);
    }
}
