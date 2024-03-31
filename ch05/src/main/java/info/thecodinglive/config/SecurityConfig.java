package info.thecodinglive.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

/**
 * WebSecurityConfigurerAdapter deprecated
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@PostConstruct
	private void init() {
		System.out.println("security config init");
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> web.ignoring().requestMatchers("/swagger-ui/**", "/js/**");
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
//			.authorizeHttpRequests((auth) -> auth.requestMatchers("/**").authenticated()
//				.anyRequest().permitAll())
			.httpBasic((httpbasic) -> httpbasic.disable())
			.headers((header) -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin))
			.sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.NEVER))
			.csrf((csrf) -> csrf.disable())
			.formLogin((form) -> form.disable());
		return http.build();
	}
}
