package info.thecodinglive.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DBConfig {

    @Value("${spring.datasource.primary.url}")
    public String dataSourceUrl;

    @Value("${spring.datasource.primary.driver-class-name}")
    public String dataSourceClassName;

    @Value("${spring.datasource.primary.username}")
    public String userName;

    @Value("${spring.datasource.primary.password}")
    public String userPassword;

    //secondary db
    @Value("${spring.datasource.secondary.url}")
    public String dataSourceSecondUrl;

    @Value("${spring.datasource.secondary.driver-class-name}")
    public String dataSourceSecondClassName;

    @Value("${spring.datasource.secondary.username}")
    public String userNameSecond;

    @Value("${spring.datasource.secondary.password}")
    public String userPasswordSecond;

    @Bean(destroyMethod = "close")
    @Primary
    @ConfigurationProperties(prefix = "datasource.primary")
    public DataSource priMarydataSource(){
        final HikariDataSource ds = new HikariDataSource();

        ds.setDriverClassName(dataSourceClassName);
        ds.setJdbcUrl(dataSourceUrl);
        ds.setUsername(userName);
        ds.setPassword(userPassword);

        return ds;
    }

    @PersistenceContext(unitName = "primary")
    @Primary
    @Bean(name = "winventionEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean winventionEntityManagerFactory(
            EntityManagerFactoryBuilder builder
    ){
        return builder
                .dataSource(priMarydataSource())
                .packages("info.thecodinglive.model.master")
                .build();
    }

    @Primary
    @Bean(name = "transactionManager")
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(winventionEntityManagerFactory(builder).getObject());
    }



    //second
    @Bean(destroyMethod = "close")
    @ConfigurationProperties(prefix = "datasource.secondary")
    public DataSource secondaryDataSource(){
        final HikariDataSource ds = new HikariDataSource();

        ds.setDriverClassName(dataSourceSecondClassName);
        ds.setJdbcUrl(dataSourceSecondUrl);
        ds.setUsername(userNameSecond);
        ds.setPassword(userPasswordSecond);

        return ds;
    }
    @PersistenceContext(unitName = "secondary")
    @Bean(name ="secondEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean wcmsEntityManagerFactory(
            EntityManagerFactoryBuilder builder
    ){
        return builder
                .dataSource(secondaryDataSource())
                .packages("info.thecodinglive.model.slave")
                .build();
    }


    @Bean(name = "secondTransactionManager")
    PlatformTransactionManager secondTransactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(wcmsEntityManagerFactory(builder).getObject());
    }


}
