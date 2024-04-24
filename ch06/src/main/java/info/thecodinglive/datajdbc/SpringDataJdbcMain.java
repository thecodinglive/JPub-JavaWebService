package info.thecodinglive.datajdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringDataJdbcMain {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataJdbcMain.class, args);
	}
}

