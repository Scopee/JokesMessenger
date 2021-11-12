package ru.pinguin.jokesmessenger.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.OAuthFlow;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Stepan Khudyakov.
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI(AuthProperties properties) {
        OpenAPI info = new OpenAPI().info(new Info().title("Jokes Messenger"));
        info.addSecurityItem(new SecurityRequirement().addList("token").addList("oauth2"))
            .components(new Components().addSecuritySchemes("token", tokenScheme()));
        if (properties.getTokenUrl() != null && !StringUtils.isEmpty(properties.getTokenUrl()))
            info.getComponents().addSecuritySchemes("oauth2", oauth2Scheme(properties.getTokenUrl()));
        return info;
    }

    private SecurityScheme oauth2Scheme(String tokenUrl) {
        return new SecurityScheme().name("oauth2")
                                   .type(SecurityScheme.Type.OAUTH2)
                                   .scheme("bearer")
                                   .in(SecurityScheme.In.HEADER)
                                   .flows(new OAuthFlows().password(new OAuthFlow().authorizationUrl(tokenUrl)
                                                                                   .tokenUrl(tokenUrl)));
    }

    private SecurityScheme tokenScheme() {
        return new SecurityScheme().name("token").type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT");
    }

}
