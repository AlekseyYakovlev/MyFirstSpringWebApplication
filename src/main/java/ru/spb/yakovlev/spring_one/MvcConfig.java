package ru.spb.yakovlev.spring_one;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;



/**
 * @author Aleksey Yakovlev on 06.02.2018
 * @project spring_one
 */
@Configuration
@EnableWebMvc
public class MvcConfig {
    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setSuffix(".jsp");
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }

    @Bean
    public Sample getSample(){
        return new Sample();
    }

    @Bean
    public DataSource dataSource (){
        DataSource dataSource = new DataSource();
        dataSource.setUrl("jdbc:sqlite:C:/Projects/Java/spring_one/src/main/resources/test1.s3db");
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }

}
