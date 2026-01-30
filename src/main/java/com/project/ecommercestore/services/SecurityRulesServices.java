package com.project.ecommercestore.services;

import com.project.ecommercestore.common.SecurityRules;
import com.project.ecommercestore.entities.Role;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.stereotype.Component;

@Component
public class SecurityRulesServices implements SecurityRules {
    @Override
    public void configure(AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry registry) {
        registry.requestMatchers("/swagger-ui/**").permitAll()
                .requestMatchers("/swagger-ui.html").permitAll()
                .requestMatchers("/v3/api-docs/**").permitAll()

                .requestMatchers("/carts/**").permitAll()

                .requestMatchers(HttpMethod.POST, "/checkout/webhook").permitAll()

                .requestMatchers("/admin/**").hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.POST, "/users").permitAll()

                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth/refresh").permitAll()

                .requestMatchers(HttpMethod.GET, "/products/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/products/**").hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.PUT, "/products/**").hasRole(Role.ADMIN.name())
                .requestMatchers(HttpMethod.DELETE, "/products/**").hasRole(Role.ADMIN.name());
    }
}
