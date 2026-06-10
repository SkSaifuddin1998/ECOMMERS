package com.erp.service.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.Scopes;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(info = @Info(title = "User Service", version = "1.0", description = "ERP User Management APIs"))
public class SwaggerConfig {

	@Value("${spring.security.oauth2.resourceserver.jwt.issuer-uri}")
	private String issuerUri;

	@Bean
	public OpenAPI customOpenAPI() {

		String authorizationUrl = issuerUri + "/protocol/openid-connect/auth";

		String tokenUrl = issuerUri + "/protocol/openid-connect/token";

		SecurityScheme securityScheme = new SecurityScheme().type(SecurityScheme.Type.OAUTH2).scheme("bearer")
				.bearerFormat("JWT")
				.flows(new OAuthFlows().authorizationCode(new OAuthFlow().authorizationUrl(authorizationUrl)
						.tokenUrl(tokenUrl).scopes(new Scopes().addString("openid", "OpenID")
								.addString("profile", "Profile").addString("email", "Email"))));

		return new OpenAPI().components(new Components().addSecuritySchemes("security_auth", securityScheme))
				.addSecurityItem(new SecurityRequirement().addList("security_auth"));
	}
}