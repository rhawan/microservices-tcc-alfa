package br.alfa.sales.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@Configuration
//@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("bill").password("123").roles("ADMIN").and()
		.withUser("bob").password("123").roles("USER").and()
		.withUser("paulo").password("123").roles("MONITOR");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.sessionManagement()
		.sessionFixation()
		.newSession();
		
		http
		.authorizeRequests()
		.anyRequest()
		.permitAll();
		
		/*http
		.formLogin();*/
	}

}
