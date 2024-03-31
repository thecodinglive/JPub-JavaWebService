package info.thecodinglive.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactoryConfig {
	@Bean
	public BeanScopeModifier beanScopeModifier() {
		return new BeanScopeModifier();
	}
}
