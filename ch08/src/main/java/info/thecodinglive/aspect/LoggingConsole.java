package info.thecodinglive.aspect;

/**
 * Created by jins on 2017-01-30.
 */
public class LoggingConsole implements Logging {
    @Override
    public void log(String str) {
       // logger.debug(str);
        System.out.println("loggingconsole::" + str);
    }
}
