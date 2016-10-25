package info.thecodinglive.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DbConfig {

    @Value("${spring.datasource.url}")
    public String dataSourceUrl;

    @Value("${spring.datasource.username}")
    public String userName;

    @Value("${spring.datasource.password}")
    public String userPassword;

    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        final HikariDataSource ds = new HikariDataSource();

        ds.setJdbcUrl(dataSourceUrl);
        ds.setUsername(userName);
        ds.setPassword(userPassword);

        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean todoEntityManagerFactory(
            EntityManagerFactoryBuilder builder
    ){
        return builder
                .dataSource(dataSource())
                .packages("info.thecodinglive.model")
                .build();
    }

    @Bean(name = "todoTransactionManager")
    PlatformTransactionManager todoTransactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(todoEntityManagerFactory(builder).getObject());
    }

    @Configuration
    @EnableJpaRepositories(basePackages = "info.thecodinglive.repository",
            entityManagerFactoryRef = "todoEntityManagerFactory", transactionManagerRef = "todoTransactionManager")
    static class TodoRepositoriesConfig{}
}
