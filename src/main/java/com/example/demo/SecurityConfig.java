package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//private final HttpSecurity httpSecurity;
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			.authorizeHttpRequests(auth -> auth
			.requestMatchers( "/swagger-ui/**",
                    "/v3/api-docs/**"
).permitAll().
			anyRequest().authenticated()			
			).oauth2Login(Customizer.withDefaults());
		
		return httpSecurity.build();
			
			
	}
	
	@Bean
	public OpenAPI customOpenAPI() {
	    return new OpenAPI()
	            .components(new Components()
	                    .addSecuritySchemes("oauth2Scheme",
	                            new SecurityScheme()
	                                    .type(SecurityScheme.Type.HTTP)
	                                    .scheme("oauth2")))
	            .addSecurityItem(new SecurityRequirement().addList("oauth2Scheme"));
	}
		
	@Configuration
	public class SwaggerConfig {

	    @Bean
	    public OpenAPI openAPI() {
	        return new OpenAPI()
	                .components(new Components()
	                        .addSecuritySchemes("oauth2Scheme",
	                                new SecurityScheme()
	                                        .type(SecurityScheme.Type.OAUTH2)
	                                        .flows(new OAuthFlows()
	                                                .authorizationCode(
	                                                        new OAuthFlow()
	                                                                .authorizationUrl("http://localhost:8081/oauth2/authorize")
	                                                                .tokenUrl("http://localhost:8081/oauth2/token")
	                                                                .scopes(new Scopes()
	                                                                        .addString("read", "Read access")
	                                                                        .addString("write", "Write access")
	                                                                )
	                                                )
	                                        )
	                        )
	                )
	                .addSecurityItem(new SecurityRequirement().addList("oauth2Scheme"));
	    }
	}
		
		
	

}

	
	