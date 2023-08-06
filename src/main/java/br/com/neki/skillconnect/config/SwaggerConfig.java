package br.com.neki.skillconnect.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
@SecurityScheme(name = "Bearer Auth", type = SecuritySchemeType.HTTP, bearerFormat = "JWT", scheme = "bearer")
public class SwaggerConfig {

	@Bean
	OpenAPI myOpenAPI() {
		Server devServer = new Server();

		devServer.setUrl("http://localhost:8080/api/");


		Contact contact = new Contact();
		contact.setEmail("letsmp4@gmail.com");
		contact.setName("Skill Connect");
		contact.setUrl("https://github.com/lepittezr");

		License license = new License().name("Apache license version 2.0")
				.url("https://www.apache.org/license/LICENSE-2.0");

		Info info = new Info().title("Documentação API").version("4.0.0").contact(contact).license(license);

		return new OpenAPI().info(info).servers(List.of(devServer));

	}

}