package ru.pinguin.jokesmessenger.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.DefaultAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import ru.pinguin.jokesmessenger.security.UserPrincipalAuthenticationConverter;

/**
 * @author Stepan Khudyakov.
 */
@Configuration
@EnableResourceServer
@SuppressWarnings("deprecation")
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
@EnableConfigurationProperties(AuthProperties.class)
public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/v3/api-docs/**")
           .antMatchers("/swagger-resources/**")
           .antMatchers("/swagger-ui/**")
           .antMatchers("/swagger-ui.html")
           // actuator
           .antMatchers("/actuator/**");
    }

    @Bean
    public ResourceServerTokenServices tokenService(AuthProperties properties) {
        RemoteTokenServices services = new RemoteTokenServices();
        DefaultAccessTokenConverter converter = new DefaultAccessTokenConverter();
        converter.setUserTokenConverter(new UserPrincipalAuthenticationConverter());
        services.setAccessTokenConverter(converter);
        services.setCheckTokenEndpointUrl(properties.getAuthServerUrl());
        services.setClientId(properties.getClient());
        services.setClientSecret(properties.getSecret());
        return services;
    }
}
