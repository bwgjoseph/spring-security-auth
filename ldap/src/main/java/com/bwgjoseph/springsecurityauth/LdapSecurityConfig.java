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
public class LdapSecurityConfig extends WebSecurityConfigurerAdapter {

	// Configure for ldap Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.ldapAuthentication()
				// If not specified, search will be done from the root of LDAP hierarchy
				// Otherwise, specify ou to search from
				.userSearchBase("ou=people")
				// {0} is substituted parameter for the user's login name
				.userSearchFilter("(uid={0})")
				// Load authorities from groups
				.groupSearchBase("ou=groups")
				.contextSource()
					.root("dc=bwgjoseph,dc=com")
					.ldif("classpath:ldap-data.ldif");
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
