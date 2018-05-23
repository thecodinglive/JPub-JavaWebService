package info.thecodinglive.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Configuration
@ComponentScan(basePackages = {"info.thecodinglive.service"},
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(Service.class)}
         )
@Import(MyBatisConfig.class)
public class ServiceConfig {
}
