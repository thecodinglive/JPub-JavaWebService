package info.thecodinglive.jackson;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JacksonTestConfig {
	/**
	 * 실행할 때는 자동으로 로딩이 된다.
	 * sliceTest를 위해서 필요하다.
	 *
	 * @return
	 */
	@Bean
	public Jackson2ObjectMapperBuilder jackson2ObjectMapperBuilder() {
		return new Jackson2ObjectMapperBuilder();
	}
}
