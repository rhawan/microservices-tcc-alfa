package br.alfa.tcc.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class OAuth2SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("bill").password("123").roles("ADMIN").and()
		.withUser("bob").password("123").roles("USER").and()
		.withUser("paulo").password("123").roles("MONITOR");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.requestMatchers()
		.antMatchers("/", "/oauth/authorize", "/oauth/confirm_access")
		.and()
		.authorizeRequests()
		.anyRequest().authenticated();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
}
