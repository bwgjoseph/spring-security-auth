/**
 * 
 */
package com.bwgjoseph.springsecurityauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Joseph Gan
 *
 */
@Configuration
@EnableWebSecurity
public class CustomSecurityConfig extends WebSecurityConfigurerAdapter {

	// Loads CustomUserDetailsService implementation
	@Autowired
	private UserDetailsService userDetailsService;
	
	// Configure for custom UserDetailsService Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService);
	}
	
	// Configure HttpSecurity
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				// requires all access to / to be authenticated
				.antMatchers("/").authenticated()
		.and()
			// Do not apply CSRF protection to /h2-console
			.csrf().ignoringAntMatchers("/h2-console/**")
			// Alternatively, could have disabled crsf
			// .csrf().disable()
		.and()
			// Allow frameOptions from same origin
		 	.headers().frameOptions().sameOrigin()
		.and()
			.formLogin()
		.and()
			.logout();
	}
}
