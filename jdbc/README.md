# spring-security-auth-jdbc

Demonstrate JDBC Authentication using Spring Security

## Project Info

Uses embedded H2 database  
Data are inserted into H2 database on startup through `data.sql` in resources directory

## Usage

Navigate to `http://localhost:8080/h2-console`, login form will be presented

Login using either of the account below

user / password  
admin / password  

Once login, you will be re-directed to `http://localhost:8080/` and presented with user account information using `sec:` keyword which is possible because of `thymeleaf-extras-springsecurity5`

## Reference Docs

1. <a href="https://springframework.guru/using-the-h2-database-console-in-spring-boot-with-spring-security/">Using the H2 Database Console in Spring Boot with Spring Security</a>
2. <a href="https://www.logicbig.com/tutorials/spring-framework/spring-boot/jdbc-security-with-h2-console.html">JDBC Authentication With H2 Console</a>
3. <a href="https://docs.spring.io/spring-security/site/docs/5.1.4.RELEASE/reference/htmlsingle/#appendix-schema">Database Schema</a>
4. <a href="https://github.com/thymeleaf/thymeleaf-extras-springsecurity">Thymeleaf Extras SpringSecurity</a>