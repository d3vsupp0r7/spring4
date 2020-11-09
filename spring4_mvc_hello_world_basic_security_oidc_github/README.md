# Scope

Implement a spring4 mvc OAuth2 Authentication without springboot framework.

# Application endpoints

**Root context:** http://localhost:8080/spring4_mvc_hello_world_basic_security_oidc_github/

**Other resource app link:** http://localhost:8080/spring4_mvc_hello_world_basic_security_oidc_github/employee-web/readEmployees  

**Root context:** http://localhost:8080/spring4_mvc_hello_world_basic_security_oidc_github/login/oauth2/code/github 


# OIDC/OAuth2 Authorization callback URL

**template url:** {baseUrl}/login/oauth2/code/{registrationId}  
ES: http://localhost:8080/spring4_mvc_hello_world_basic_security_oidc_github/login/oauth2/code/github  

# Important security patter for SecurityConfig

This configuration shows the root context as not protected, and every other path requires authentication  

## Spring security context path config (Base)

```
http.antMatcher("/**").authorizeRequests()
.antMatchers("/").permitAll()
.anyRequest().authenticated()
.and().oauth2Login();
```

## Spring security context path config (Using OAuth2 approach)

```
@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/oauth2/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.oauth2Login()
		.clientRegistrationRepository(ClientRegistrationRepository())
		.authorizedClientService(authorizedClientService())
		.and()
		.csrf().disable();
		;
	}
```	

## Maven dependency

### Versions
spring-security was needed for **oauth2Login()** method.

```
...
		<!-- Spring version -->
		<spring.version>4.3.10.RELEASE</spring.version>
		<spring-integration.version>4.3.10.RELEASE</spring-integration.version>
		<spring-data.version>1.6.6.RELEASE</spring-data.version>

		<!-- Spring Security -->
		<spring-security.version>5.0.0.RELEASE</spring-security.version>
		<!-- Spring Security OAuth2 - OIDC -->
		<spring-oauth2.version>5.0.0.RELEASE</spring-oauth2.version>
		
		<!-- Util library -->
		<jackson.version>2.11.3</jackson.version>
...
```

### Dependency

```
		<!-- Spring Framework - START -->
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-core</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-context</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-web</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>${spring.version}</version>
		</dependency>
		<!-- Spring Framework - END -->

		<!-- Spring Security -->
		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-core</artifactId>
			<version>${spring-security.version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-web</artifactId>
			<version>${spring-security.version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-config</artifactId>
			<version>${spring-security.version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-taglibs</artifactId>
			<version>${spring-security.version}</version>
		</dependency>

		<!-- Spring Security OAuth2/OIDC - START -->

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-oauth2-client</artifactId>
			<version>${spring-oauth2.version}</version>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-oauth2-jose</artifactId>
			<version>${spring-oauth2.version}</version>
		</dependency>

		<!-- Spring Security OAuth2/OIDC - END -->
		
		<!-- Jackson -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>${jackson.version}</version>
		</dependency>

		<dependency>
			<groupId>com.fasterxml.jackson.jaxrs</groupId>
			<artifactId>jackson-jaxrs-json-provider</artifactId>
			<version>${jackson.version}</version>
		</dependency>
		
```

# GitHub reference

Implicit flow not supported by Github  
https://docs.github.com/en/free-pro-team@latest/developers/apps/authorizing-oauth-apps

## Baeldung
https://www.baeldung.com/spring-security-5-oauth2-login#1-creating-a-clientregistrationrepository-bean