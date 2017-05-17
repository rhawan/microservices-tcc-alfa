package br.alfa.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SalesMicroservicesResourceServerProdutoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SalesMicroservicesResourceServerProdutoApplication.class, args);
	}
}
