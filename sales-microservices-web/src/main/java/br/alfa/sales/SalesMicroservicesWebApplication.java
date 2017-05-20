package br.alfa.sales;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;

import feign.RequestInterceptor;
import feign.RequestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class SalesMicroservicesWebApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SalesMicroservicesWebApplication.class, args);
	}
	
	@Bean(name = "messageSource")
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("validation");
		return messageSource;
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
