package br.alfa.sales.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2ClientContext;

import feign.RequestInterceptor;

@Configuration
public class SalesWebClientConfiguration {
	
	@Bean
	public RequestInterceptor oauth2FeignRequestInterceptor(OAuth2ClientContext oAuth2ClientContext) {
		return new FeignOAuthInterceptor(oAuth2ClientContext);
	}

}
