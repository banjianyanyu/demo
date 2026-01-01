package com.bjyy.app.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;


/**
 * @author Aurora
 * @date 2026年01月01日 11:14
 */
@Configuration
//指定配置类，将DataSourceProperties类中的属性注入到该类中
@EnableConfigurationProperties(DataSourceProperties.class)
public class AppConfiguration {

    DataSourceProperties dataSourceProperties = new DataSourceProperties();

    public AppConfiguration(DataSourceProperties dataSourceProperties) {
        this.dataSourceProperties = dataSourceProperties;
    }

    @Bean
    //该注解含义缺少DataSource的时候，创建DataSource
    @ConditionalOnMissingBean({DataSource.class})
    public DataSource getDataSource() {
        DruidDataSource druidDataSource =new DruidDataSource();
        druidDataSource.setDriverClassName(dataSourceProperties.getDriver());
        druidDataSource.setUrl(dataSourceProperties.getUrl());
        druidDataSource.setUsername(dataSourceProperties.getUsername());
        druidDataSource.setPassword(dataSourceProperties.getPassword());
        return druidDataSource;
    }
}
