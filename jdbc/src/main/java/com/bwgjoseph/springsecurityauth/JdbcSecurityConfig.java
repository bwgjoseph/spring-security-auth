/**
 * 
 */
package com.bwgjoseph.springsecurityauth;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
public class JdbcSecurityConfig extends WebSecurityConfigurerAdapter {

	// With h2 configured in the classpath, datasource for h2 will be
	// auto-configured by spring
	@Autowired
	private DataSource dataSource;
	
	// Configure for jdbc Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.withDefaultSchema()
				// Use NoOpPasswordEncoder by specifying {noop}
				.withUser("user").password("{noop}password").roles("USER")
				.and()
				.withUser("admin").password("{noop}password").roles("USER", "ADMIN");
	}
	
	// Configure HttpSecurity
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				// Allow only user with ADMIN role to access /h2-console
				.antMatchers("/h2-console/**").hasRole("ADMIN")
				// Allow all to access /
				.antMatchers("/").permitAll()
		.and()
			// Do not apply CSRF protection to /h2-console
			.csrf().ignoringAntMatchers("/h2-console/**")
			// Alternatively, could have disabled crsf
			// .csrf().disable()
		.and()
			// Allow frameOptions from same origin
		 	.headers().frameOptions().sameOrigin()
		 	// Alternatively, could have disabled frameOptions
		 	// .headers().frameOptions().disable()
		 .and()
		 	.formLogin()
		 	// Always redirect to / after login
		 	.defaultSuccessUrl("/", true)
		 .and()
		 	.logout();
	}
}
