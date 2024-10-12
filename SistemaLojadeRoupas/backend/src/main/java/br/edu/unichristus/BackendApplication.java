package br.edu.unichristus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "API Backend Topicos Especiais",
				version = "1.0",
				description = "Trata-se da API que está sendo desenvolvida na disicplina TEPW",
				contact = @Contact(
						name = "Unichristus",
						email = "adriano.candido@unichristus.edu.br",
						url = "https://www.google.com")
		)
)

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
