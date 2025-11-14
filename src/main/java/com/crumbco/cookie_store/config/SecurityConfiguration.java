package com.crumbco.cookie_store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/", "/about", "/contact").permitAll()
                        .requestMatchers("/dashboard", "/inventory", "/cookie/**").authenticated()
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/dashboard", true)
                )
                .logout(logout -> logout
                        .permitAll()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/cookie/add", "/cookie/edit/**", "/cookie/remove/**")
                );

        return http.build();
    }
}
