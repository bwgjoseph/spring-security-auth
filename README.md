# spring-security-auth

Showcase of using different type of Authentication method in Spring Security

## Project Info

This project is build using

1. Java OpenJDK 11.0.1
2. Maven Wrapper 3.6.0

This should work with `JDK 8` and higher. 
> If you are using `JDK 8`, then you can edit the `pom.xml` to set `java.version` to 8

## Project Structure

In each of the sub-directory, you will find the implementation of various authentication method in Spring Security namely,

1. In Memory
2. JDBC
3. LDAP
4. Custom

## Project Maven build

In the root directory, run

`mvnw clean package`

Which will triggers a build on all the sub-modules

To run each individual module, run either one of the following command

`mvnw spring-boot:run -pl inmemory`  
`mvnw spring-boot:run -pl jdbc`  
`mvnw spring-boot:run -pl ldap`  
`mvnw spring-boot:run -pl custom`  

Refer to the individual module `README.md` for more information