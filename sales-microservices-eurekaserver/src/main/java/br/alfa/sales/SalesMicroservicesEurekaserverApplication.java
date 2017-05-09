package br.alfa.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SalesMicroservicesEurekaserverApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SalesMicroservicesEurekaserverApplication.class, args);
	}
}
