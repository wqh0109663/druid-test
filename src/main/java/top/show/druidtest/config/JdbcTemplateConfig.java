package top.show.druidtest.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 吴启欢
 * @version 1.0
 * @date 19-7-24 下午8:38
 */
@Configuration
@Primary
public class JdbcTemplateConfig extends DataSourceProperties{
    /**
     * 设置jdbcTemplate
     * @param druidDataSource druidDataSource
     * @return jdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate( DruidDataSource druidDataSource){
        return  new JdbcTemplate(druidDataSource);
    }

    /**
     * 设置druidDataSource
     * @return druidDataSource
     */
    @Bean
    public DruidDataSource druidDataSource(){
        return dataSourceProperties().initializeDataSourceBuilder().type(DruidDataSource.class).build();
    }

    /**
     * 装载配置文件
     * @return dataSourceProperties
     */
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }
}
