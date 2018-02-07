package info.thecodinglive.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

/**
 * Created by yun_dev1 on 2017-01-23.
 */
@Configuration
public class DBConfig {
    @Bean
    public DataSource dataSource(){
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        EmbeddedDatabase h2 = builder
                .setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema-h2.sql")
                .addScript("classpath:data-h2.sql")
                .build();

        return h2;
    }

    @PostConstruct
    public void onCreate(){

    }
}
