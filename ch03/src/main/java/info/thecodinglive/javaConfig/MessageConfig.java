package info.thecodinglive.javaConfig;

import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfig {
    protected String getMessage() {
        return "Hello";
    }
}
