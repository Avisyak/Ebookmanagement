package com.Broadway.FinalprojectBroadway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="BookMs",description = "BooksApis",version = "2.8"))
public class FinalprojectBroadwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalprojectBroadwayApplication.class, args);
	}

}
