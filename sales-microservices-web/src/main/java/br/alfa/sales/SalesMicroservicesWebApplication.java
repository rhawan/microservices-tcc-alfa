package br.alfa.sales;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.alfa.sales.config.SalesWebClientConfiguration;
import feign.RequestInterceptor;
import feign.RequestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
//@EnableOAuth2Client
@RestController
public class SalesMicroservicesWebApplication {
	
	@Autowired
	private HelloClient client;
	
	@Autowired
	private OAuth2ClientContext oAuth2ClientContext;

	public static void main(String[] args) {
		SpringApplication.run(SalesMicroservicesWebApplication.class, args);
	}
	
	@RequestMapping("/")
	public String hello() {
		return client.hello();
	}
	
	@FeignClient(name = "resource-cliente", configuration = SalesWebClientConfiguration.class)
	interface HelloClient {
		@RequestMapping(value = "/", method = GET)
		String hello();
	}
	
	@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {
		return new RequestInterceptor() {
			@Override
			public void apply(RequestTemplate requestTemplate) {

				/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				String name = auth.getName(); //get logged in username

				System.out.println("AUTH = " + auth);

				System.out.println("------- NAME = " + name);


				System.out.println("------- " + SecurityContextHolder.getContext());

				OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
						SecurityContextHolder.getContext().getAuthentication().getDetails();*/

				requestTemplate.header("Authorization", "bearer " + oAuth2ClientContext.getAccessToken().getValue());
			}
		};
	}
}
