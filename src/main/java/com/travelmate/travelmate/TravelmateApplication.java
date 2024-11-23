package com.travelmate.travelmate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "TravelMate API Documentation", version = "1.0", description = "All APIs in TravelMate Backend Server Application"))
public class TravelmateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelmateApplication.class, args);
	}

}
