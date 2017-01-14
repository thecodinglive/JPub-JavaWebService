package info.thecodinglive.config;

import info.thecodinglive.service.ConsoleHello;
import info.thecodinglive.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(HelloService.class)
public class HelloServiceAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public HelloService helloService(){return new ConsoleHello();}
}
