package com.travelmate.travelmate.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseInitializer {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private boolean isDataPresent() {
        Integer provinceCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM province_entity", Integer.class);
        Integer districtCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM district_entity", Integer.class);
        Integer cityCount = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM city_entity", Integer.class);

        return (provinceCount != null && provinceCount > 0) ||
                (districtCount != null && districtCount > 0) ||
                (cityCount != null && cityCount > 0);
    }

    @PostConstruct
    public void init() {
        if (!isDataPresent()) {
            try {
                ResourceDatabasePopulator resourceDatabasePopulator = new ResourceDatabasePopulator();
                resourceDatabasePopulator.addScript(new ClassPathResource("data/provinces.sql"));
                resourceDatabasePopulator.addScript(new ClassPathResource("data/districts.sql"));
                resourceDatabasePopulator.addScript(new ClassPathResource("data/cities.sql"));
                resourceDatabasePopulator.execute(dataSource);
            } catch (ScriptException e) {
                e.printStackTrace();
            }
        }
    }
}
