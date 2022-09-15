/*******************************************************************************
 * 
 * Autor: coe.architecture@axpe.com
 * 
 * © Axpe Consulting S.L. 2022. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.axpe.exercices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * Clase para arrancar el Webnode como una aplicación Spring-boot
 * 
 * @author coe.architecture@axpe.com
 *
 */
@SpringBootApplication
@EnableConfigurationProperties
@OpenAPIDefinition(	info = @Info(	title = "API EMPLOYEE - AXPE",
									version = "Versión 2.0.0",
									description = "Application within the technological framework of API Methodology.",
									contact = @Contact(name = "Álvaro Martín", email = "alvaromrtn@gmail.com")),
					servers = {		@Server(description = "Production server", url = "http://54.174.126.218:8000"),
									@Server(description = "Development server", url = "http://localhost:8080")})
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
}