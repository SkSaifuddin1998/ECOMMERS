
package com.erp.service.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@OpenAPIDefinition(info = @Info(title = "User Service", description = "User Service API", version = "1.0"))
//@SecurityScheme(name = "security_auth", type = SecuritySchemeType.OAUTH2, flows = @OAuthFlows(authorizationCode = @OAuthFlow(authorizationUrl = "${springdoc.oAuthFlow.authorizationUrl}", tokenUrl = "${springdoc.oAuthFlow.tokenUrl}")))
@Configuration
public class SwaggerConfig {
	
	@Bean
	public OpenAPI openAPI() {

		SecurityScheme scheme = new SecurityScheme().type(SecurityScheme.Type.OAUTH2)
				.flows(new OAuthFlows().authorizationCode(new OAuthFlow()
						.authorizationUrl("http://localhost:9090/realms/erp/protocol/openid-connect/auth")
						.tokenUrl("http://localhost:9090/realms/erp/protocol/openid-connect/token")
						.scopes(new Scopes().addString("openid", "OpenID Connect").addString("profile", "User profile")
								.addString("email", "User email"))));

		return new OpenAPI().components(new Components().addSecuritySchemes("security_auth", scheme))
				.addSecurityItem(new SecurityRequirement().addList("security_auth", java.util.List.of("openid")));
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/swagger-ui/**", "/swagger-ui.html", "/v3/api-docs/**")
								.permitAll().anyRequest().authenticated())
				.oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

		return http.build();
	}
}
