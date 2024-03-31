package info.thecodinglive.javaconfig;

import org.springframework.context.annotation.Configuration;

import java.beans.ConstructorProperties;

@Configuration
public class DBConnectionConfig {
	private String url;
	private String driverName;
	private Integer port;

	public String getUrl() {
		return url;
	}

	public String getDriverName() {
		return driverName;
	}

	public Integer getPort() {
		return port;
	}

	@ConstructorProperties({"url", "driverName", "port"})
	public DBConnectionConfig(String url, String driverName, Integer port) {
		this.url = url;
		this.driverName = driverName;
		this.port = port;
	}
}
