package com.bjyy.app.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Aurora
 * @date 2026年01月01日 12:05
 */
@ConfigurationProperties("druid.datasource")
@Data
public class DataSourceProperties {

    private String password;

    private String username;

    private String url;

    private String driver;
}
