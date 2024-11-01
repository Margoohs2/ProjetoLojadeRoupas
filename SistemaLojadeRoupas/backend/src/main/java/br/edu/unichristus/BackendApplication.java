package br.edu.unichristus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "API Loja de Roupas",
				version = "1.0",
				description = "Projeto de uma API para uma loja de roupas.",
				contact = @Contact(
						name = "Unichristus",
						url = "https://www.google.com")
		)
)

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}