package ru.bul.springs.SecApp.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SqlTestConfig {
    @Bean
    DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(2);
        config.setDriverClassName("org.postgresql.Driver");
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/projectest");
        config.setUsername("postgres");
        config.setPassword("Bulat2001,");
        return new HikariDataSource(config);
    }
}
