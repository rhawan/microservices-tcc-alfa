package br.alfa.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SalesMicroservicesWebApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
		SpringApplication.run(SalesMicroservicesWebApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SalesMicroservicesWebApplication.class);
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

				//requestTemplate.header("Authorization", "bearer " + oAuth2ClientContext.getAccessToken().getValue());
			}
			
		};
	}
}
