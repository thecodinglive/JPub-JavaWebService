package info.thecodinglive.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CompanyConfig {
	@Bean
	public Company company() {
		return new Company("jpub");
	}
}
