package com.travelmate.travelmate.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.jdbc.datasource.init.ScriptException;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

@Component
public class InsertDataController {

    @Autowired
    private DataSource dataSource;

    private boolean isDataPresent() {
        boolean dataPresent = false;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {

            ResultSet provinceResult = statement.executeQuery("SELECT COUNT(*) FROM province_entity");
            if (provinceResult.next() && provinceResult.getInt(1) > 0) {
                dataPresent = true;
            }

            ResultSet districtResult = statement.executeQuery("SELECT COUNT(*) FROM district_entity");
            if (districtResult.next() && districtResult.getInt(1) > 0) {
                dataPresent = true;
            }

            ResultSet cityResult = statement.executeQuery("SELECT COUNT(*) FROM city_entity");
            if (cityResult.next() && cityResult.getInt(1) > 0) {
                dataPresent = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return dataPresent;
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
