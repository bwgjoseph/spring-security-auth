/**
 * 
 */
package com.bwgjoseph.springsecurityauth;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Joseph Gan
 *
 */
@Configuration
@EnableWebSecurity
public class InMemorySecurityConfig extends WebSecurityConfigurerAdapter {

	// Configure for in-memory Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.inMemoryAuthentication()
				.withUser("user")
					// Password is prefixed with {noop} to indicate to DelegatingPasswordEncoder that
				    // NoOpPasswordEncoder should be used. This is not safe for production, but makes reading
				    // in samples easier. Normally passwords should be hashed using BCrypt
					// See https://docs.spring.io/spring-security/site/docs/5.1.4.RELEASE/reference/htmlsingle/#core-services-in-memory-service
					.password("{noop}password")
					.roles("USER")
			.and()
				.withUser("admin")
					.password("{noop}password")
					.roles("USER", "ADMIN");
	}
	
	// Configure HttpSecurity
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				// requires all access to / to be authenticated
				.antMatchers("/").authenticated()
		.and()
			.formLogin()
		.and()
			.logout();
	}
}
