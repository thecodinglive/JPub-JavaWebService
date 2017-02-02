package info.thecodinglive.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by jins on 2017-01-30.
 */
@Configuration
@ComponentScan(basePackages = {"info.thecodinglive.service"},
        includeFilters = {
                @ComponentScan.Filter({Service.class, Component.class })}
         )
@Import(MyBatisConfig.class)
public class ServiceConfig {
}
