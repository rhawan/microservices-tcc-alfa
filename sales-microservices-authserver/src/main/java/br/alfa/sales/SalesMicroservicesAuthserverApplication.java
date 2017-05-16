package br.alfa.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SalesMicroservicesAuthserverApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SalesMicroservicesAuthserverApplication.class, args);
	}
}
