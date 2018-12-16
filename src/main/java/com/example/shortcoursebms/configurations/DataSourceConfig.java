package com.example.shortcoursebms.configurations;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@MapperScan({"com.example.shortcoursebms.repositories"})
public class DataSourceConfig {

    @Bean("datasource")
    @Profile("pgsql")
    public DataSource dataSource() {

        DriverManagerDataSource managerDataSource = new DriverManagerDataSource();
        managerDataSource.setDriverClassName("org.postgresql.Driver");
        managerDataSource.setUrl("jdbc:postgresql://localhost:5432/short_course_bms_db");
        managerDataSource.setUsername("postgres");
        managerDataSource.setPassword("root");

        return managerDataSource;
    }

    @Bean("datasource")
    @Profile("inMemoryDB")
    public DataSource inMemoryDB() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();

        builder.setType(EmbeddedDatabaseType.H2);

        builder.addScript("db/schema.sql")
                .addScript("db/data.sql");

        return builder.build();

    }


    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }


}
