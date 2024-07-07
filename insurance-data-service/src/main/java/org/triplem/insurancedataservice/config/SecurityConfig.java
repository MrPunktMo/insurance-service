package org.triplem.insurancedataservice.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.core.oidc.StandardClaimNames;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import java.util.*;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(
            HttpSecurity http,
            ServerProperties serverProperties,
            KeycloakAuthenticationConverter converter,
            @Value("${security-matchers}") String[] securityMatchers,
            @Value("${permit-all}") String[] permitAll,
            @Value("${authorize-admin}") String[] authorizeAdmin,
            @Value("${authorize-user}") String[] authorizeUser
    ) throws Exception {

        // Configure a resource server with JWT decoder (the customized jwtAuthenticationConverter is picked by Spring Boot)
        http.oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.jwtAuthenticationConverter(converter)));

        // State-less session (state in access-token only)
        http.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        // Disable CSRF because of state-less session-management
        http.csrf(AbstractHttpConfigurer::disable);

        // Return 401 (unauthorized) instead of 302 (redirect to login) when
        // authorization is missing or invalid
        http.exceptionHandling(eh -> eh.authenticationEntryPoint((request, response, authException) -> {
            response.addHeader(HttpHeaders.WWW_AUTHENTICATE, "Bearer realm=\"Restricted Content\"");
            response.sendError(HttpStatus.UNAUTHORIZED.value(), HttpStatus.UNAUTHORIZED.getReasonPhrase());
        }));

        // If SSL enabled, disable http (https only)
        if (serverProperties.getSsl() != null && serverProperties.getSsl().isEnabled()) {
            http.requiresChannel(channel -> channel.anyRequest().requiresSecure());
        }

        //securit matchers
        http.securityMatcher(securityMatchers);

        //Configure which request to authenticate
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers(Arrays.stream(authorizeAdmin).map(AntPathRequestMatcher::new).toArray(AntPathRequestMatcher[]::new)).hasAuthority("admin")
                .requestMatchers(HttpMethod.GET, "/fee").hasAuthority("admin")
                .requestMatchers(Arrays.stream(authorizeUser).map(AntPathRequestMatcher::new).toArray(AntPathRequestMatcher[]::new)).hasAnyAuthority("admin", "user")
                .requestMatchers(Arrays.stream(permitAll).map(AntPathRequestMatcher::new).toArray(AntPathRequestMatcher[]::new)).permitAll()
                .anyRequest().authenticated());

        return http.build();

    }

    @Component
    static class KeycloakAuthoritiesConverter implements Converter<Jwt, List<SimpleGrantedAuthority>> {

        @Override
        @SuppressWarnings({"unchecked" })
        public List<SimpleGrantedAuthority> convert(Jwt jwt) {
            final var realmAccess = (Map<String, Object>) jwt.getClaims().getOrDefault("realm_access", Map.of());
            final var roles = (List<String>) realmAccess.getOrDefault("roles", List.of());
            // add some processing here like a "ROLE_" prefix if you prefer hasRole over hasAuthority and your Keycloak roles do not start with ROLE_ already
            return roles.stream().map(SimpleGrantedAuthority::new).toList();
        }
    }

    @Component
    static class KeycloakAuthenticationConverter implements Converter<Jwt, JwtAuthenticationToken> {

        private final KeycloakAuthoritiesConverter authoritiesConverter;

        public KeycloakAuthenticationConverter(KeycloakAuthoritiesConverter converter) {
            this.authoritiesConverter = converter;
        }

        @Override
        public JwtAuthenticationToken convert(Jwt jwt) {
            return new JwtAuthenticationToken(jwt, authoritiesConverter.convert(jwt), jwt.getClaimAsString(StandardClaimNames.PREFERRED_USERNAME));
        }
    }

}
