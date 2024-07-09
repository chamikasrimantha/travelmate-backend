package com.travelmate.travelmate.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class DatabaseInitializer {

    @Autowired
    private DataSource dataSource;

    @PostConstruct
    public void init() {
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

