package susalud.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import susalud.backend.dominio.sistema.rol.servicio.RolServicio;

@EnableDiscoveryClient
@SpringBootApplication
public class SusaludAeApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SusaludAeApplication.class);
	
	@Autowired
	private RolServicio rolServicio;
	
	public static void main(String[] args) {
		SpringApplication.run(SusaludAeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		log.info("*** reload all roles ***");		
		rolServicio.cargarRoles();		
	
	}


}
