package info.thecodinglive.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration("classpath:application.properties")
public class DBConfig {
    @Value("${spring.datasource.url}")
    public String dataSourceUrl;

    @Value("${spring.datasource.driver-class-name}")
    public String dataSourceClassName;

    @Value("${user.name}")
    public String userName;

    @Bean(destroyMethod = "close")
    public DataSource dataSource(){
        final HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName(dataSourceClassName);
        ds.setJdbcUrl(dataSourceUrl);
        ds.setUsername(userName);

        return ds;
    }

    @Primary
    @Bean(name = "todoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean todoEntityManagerFactory(EntityManagerFactoryBuilder builder){

        return builder
                .dataSource(dataSource())
                .packages("info.thecodinglive.model")
                .build();
    }

    @Bean(name = "transactionManager")
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder){
        return new JpaTransactionManager(todoEntityManagerFactory(builder).getObject());
    }

    @Configuration
    @EnableJpaRepositories(basePackages = "info.thecodinglive.repository",
        entityManagerFactoryRef = "todoEntityManagerFactory", transactionManagerRef = "transactionManager")
    static class TodoJpaRepositoryConfig{}
}
