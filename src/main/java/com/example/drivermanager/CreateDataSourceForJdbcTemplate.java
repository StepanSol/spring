package com.example.drivermanager;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class CreateDataSourceForJdbcTemplate {
    public static DriverManagerDataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres?currentSchema=stepan_company");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres");
        return dataSource;
    }
}
