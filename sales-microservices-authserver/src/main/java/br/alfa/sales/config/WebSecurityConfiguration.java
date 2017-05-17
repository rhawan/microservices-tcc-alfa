package br.alfa.sales.config;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
			.exceptionHandling()
			.authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
		.and()
			.requestMatchers()
			.antMatchers("/oauth/authorize", "/oauth/confirm_access", "/oauth/token")
			.and()
			.authorizeRequests()
			.antMatchers("/**").authenticated()
			.and()
			.anonymous().disable();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("cliente")
			.password("cliente")
			.authorities("ADMIN_CLIENTE", "ADMIN_PRODUTO")
			.and()
			.withUser("writer")
			.password("writer")
			.authorities("FOO_READ", "FOO_WRITE")
			.and()
			.withUser("test")
			.password("test")
			.authorities("BLA_BLA");
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
}
