package info.thecodinglive.javaconfig;

import org.springframework.context.annotation.Configuration;

@Configuration
public class DBConfig {
	public DBConnectionConfig dbConnectionConfig(String url, String driverName, Integer port) {
		return new DBConnectionConfig(url, driverName, port);
	}

}
