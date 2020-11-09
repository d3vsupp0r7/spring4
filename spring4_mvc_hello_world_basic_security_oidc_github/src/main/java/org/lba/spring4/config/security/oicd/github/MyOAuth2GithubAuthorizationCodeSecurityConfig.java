package org.lba.spring4.config.security.oicd.github;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MyOAuth2GithubAuthorizationCodeSecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 By default, Spring Boot configures this redirect URI as 
	 /login/oauth2/code/{registrationId}. Therefore, for Google we'll add the URI:
     http://localhost:8081/login/oauth2/code/google
	
	 */
	
	@Bean
	public ClientRegistrationRepository ClientRegistrationRepository() {
		
		String registrationId = "github";
		/**/
		ClientRegistration.Builder builder = ClientRegistration.withRegistrationId(registrationId);
		/**/
		builder.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE);
		builder.clientId("YOUR_GITHUB_CLIENT_ID");
		builder.clientSecret("YOUR_GITHUB_CLIENT_SECRET");
		builder.redirectUriTemplate("{baseUrl}/login/oauth2/code/{registrationId}");
		/**
		 https://accounts.google.com/o/oauth2/v2/auth
		 https://github.com/login/oauth/authorize
		 */
		builder.authorizationUri("https://github.com/login/oauth/authorize");
		builder.tokenUri("https://github.com/login/oauth/access_token");
		builder.userInfoUri("https://api.github.com/user");
		builder.scope("user:email","read:user");
		/*user_name*/
		builder.userNameAttributeName("login");
		/*spring4 additional*/
		builder.clientName("Github");
		/**/
		return new InMemoryClientRegistrationRepository(builder.build());
	}
	
	@Bean
	public OAuth2AuthorizedClientService authorizedClientService() {
	 
	    return new InMemoryOAuth2AuthorizedClientService(
	    		ClientRegistrationRepository());
	}
	
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
		 
}
