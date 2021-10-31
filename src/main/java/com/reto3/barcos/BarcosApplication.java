//categoria, mensaje, reservacion, cliente , barco
//1.modelo o entidad 
//2.interfaces 
//3.repositorio
//4.servicios
//5.controlador o web



package com.reto3.barcos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.reto3.barcos.modelo"})
public class BarcosApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarcosApplication.class, args);
	}

}
