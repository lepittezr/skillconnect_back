package br.com.neki.skillconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;


@SpringBootApplication
@EntityScan({"br.com.neki.skillconnect.security.domain", "br.com.neki.skillconnect.domain"})
public class SkillconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkillconnectApplication.class, args);
	}

}
