package com.tony.conf;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
public class DBConfiguration {

  @Bean
  @Primary
  @ConfigurationProperties("spring.datasource")
  public DataSource accountDS() {
    return new DruidDataSource();
  }

  @Bean
  public JdbcTemplate accountJdbcTemplate(DataSource ds) {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
    jdbcTemplate.update("delete from account_tbl where user_id = 'U100001'");
    jdbcTemplate.update("insert into account_tbl(user_id, money) values ('U100001', 10000)");
    return jdbcTemplate;
  }

}
