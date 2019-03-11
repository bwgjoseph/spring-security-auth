# spring-security-auth-ldap

Demonstrate LDAP Authentication using Spring Security

## Project Info

Uses embedded <a href="https://ldap.com/unboundid-ldap-sdk-for-java/">Unboundid-LDAP</a>  
Data are inserted on startup through `ldap-data.ldif` in resources directory

## Usage

Navigate to `http://localhost:8080/`, login form will be presented

Login using either of the account below

ben / password  
bob / password  

Once login, you will be presented with user account information using `sec:` keyword which is possible because of `thymeleaf-extras-springsecurity5`

## Reference Docs

1. <a href="https://spring.io/guides/gs/authenticating-ldap/">Authenticating a User with LDAP</a>
2. <a href="https://docs.spring.io/spring-security/site/docs/5.1.4.RELEASE/reference/htmlsingle/#loading-authorities">Loading LDAP Authorities</a>
3. <a href="https://docs.spring.io/spring-security/site/docs/current/api/">DefaultLdapAuthoritiesPopulator</a>
4. <a href="https://spapas.github.io/2013/10/14/spring-ldap-custom-authorities/">Custom LdapAuthoritiesPopulator</a>
5. <a href="https://github.com/thymeleaf/thymeleaf-extras-springsecurity">Thymeleaf Extras SpringSecurity</a>
6. <a href="https://stackoverflow.com/questions/18756688/what-are-cn-ou-dc-in-an-ldap-search">What are CN, OU, DC in an LDAP search?</a>