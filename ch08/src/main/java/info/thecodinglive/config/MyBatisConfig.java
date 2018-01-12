package info.thecodinglive.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Created by yun_dev1 on 2017-01-06.
 */
@Configuration
@ComponentScan(basePackages = {"info.thecodinglive.repository"})
@Import(DBConfig.class)
public class MyBatisConfig {
    @Autowired
    DBConfig dbConfig;

    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception{
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dbConfig.dataSource());
        sqlSessionFactoryBean.setConfigLocation((new PathMatchingResourcePatternResolver().getResource("classpath:mybatis/mybatis-config.xml")));
        sqlSessionFactoryBean.setMapperLocations(
            new PathMatchingResourcePatternResolver().getResources("classpath:user/mapper/*.xml"));
        return sqlSessionFactoryBean.getObject();
    }

}
