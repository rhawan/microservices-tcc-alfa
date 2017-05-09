package br.alfa.sales;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SalesMicroservicesResourceServerClienteApplication {
	
	@Autowired
	private DiscoveryClient discoveryClient;

	public static void main(String[] args) {
		SpringApplication.run(SalesMicroservicesResourceServerClienteApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		ServiceInstance localInstance = discoveryClient.getLocalServiceInstance();
		return "Hello world: " + localInstance.getServiceId() + ":" +
				localInstance.getHost() + ":" + localInstance.getPort();
	}
}
