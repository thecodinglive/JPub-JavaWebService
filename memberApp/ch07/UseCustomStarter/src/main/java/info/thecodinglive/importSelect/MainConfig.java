package info.thecodinglive.importSelect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoMyModule("someValue")
public class MainConfig {
    @Bean
    public UseMyBean useMyBean() {
        return new UseMyBean();
    }
}
