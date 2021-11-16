package ru.pinguin.jokesmessenger.auth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.jwt.crypto.sign.MacSigner;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import ru.pinguin.jokesmessenger.auth.security.CustomAccessTokenConverter;
import ru.pinguin.jokesmessenger.auth.security.CustomUserAuthenticationConverter;

/**
 * @author Stepan Khudyakov.
 */
@Configuration
@RequiredArgsConstructor
@SuppressWarnings("deprecation")
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class OAuth2SecurityConfig extends WebSecurityConfigurerAdapter {


    private final JwtDecoder decoder;

    private final MacSigner signer;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
        http.oauth2ResourceServer().jwt().authenticationManager(providerManager());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        web.ignoring()         // swagger
           .antMatchers("/v3/api-docs/**")
           .antMatchers("/swagger-resources/**")
           .antMatchers("/swagger-ui/**")
           .antMatchers("/swagger-ui.html")
           .antMatchers("/api/v1/auth/register")
           // actuator
           .antMatchers("/actuator/**");
    }

    @Bean
    public JwtAccessTokenConverter converter(UserDetailsService service) {
        JwtAccessTokenConverter jwt = new JwtAccessTokenConverter();
        CustomAccessTokenConverter defaultAccessTokenConverter = new CustomAccessTokenConverter();
        CustomUserAuthenticationConverter converter = new CustomUserAuthenticationConverter();
        converter.setUserDetailsService(service);
        defaultAccessTokenConverter.setUserTokenConverter(converter);
        jwt.setAccessTokenConverter(defaultAccessTokenConverter);
        jwt.setSigner(signer);
        jwt.setVerifier(signer);
        return jwt;
    }

    protected ProviderManager providerManager() {
        JwtAuthenticationProvider provider = new JwtAuthenticationProvider(decoder);
        provider.setJwtAuthenticationConverter(jwtAuthenticationConverter());
        return new ProviderManager(provider);
    }

    private JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("authorities");
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("");
        JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
        return jwtAuthenticationConverter;
    }
}
