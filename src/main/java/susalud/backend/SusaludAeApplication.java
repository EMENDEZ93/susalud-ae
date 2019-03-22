package susalud.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableAutoConfiguration // defines this as a Spring Boot application
@EnableDiscoveryClient
@SpringBootApplication
public class SusaludAeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SusaludAeApplication.class, args);
	}

	@RequestMapping(value = "/")
	public String home() {
		return "Eureka Client application";
	}

}
