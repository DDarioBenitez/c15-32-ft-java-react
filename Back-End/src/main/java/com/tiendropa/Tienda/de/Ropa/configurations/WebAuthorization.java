package com.tiendropa.Tienda.de.Ropa.configurations;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebAuthorization {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests((authorizeHttpRequests) ->

                        authorizeHttpRequests
                                .requestMatchers(new AntPathRequestMatcher("/api/login", "POST")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/api/logout", "POST")).permitAll()
                                .requestMatchers(new AntPathRequestMatcher("/api/register/cliente", "POST")).permitAll()
                                .anyRequest().authenticated()
                )
                .cors(cors -> cors.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()))

                .formLogin(formLogin -> formLogin

                        .usernameParameter("email")
                        .passwordParameter("password")
                        .loginPage("/api/login"))

                .logout(logout -> logout.logoutUrl("/api/logout"))

                // turn off checking for CSRF tokens
                .csrf(AbstractHttpConfigurer::disable)
                

                //disabling frameOptions so h2-console can be accessed
                .headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))

                // if user is not authenticated, just send an authentication failure response
                .exceptionHandling(exceptionHandling -> exceptionHandling.authenticationEntryPoint((request, response, authException) -> clearAuthenticationAttributes(request)))

                // if login is successful, just clear the flags asking for authentication
                .formLogin(formLogin -> formLogin.successHandler((request, response, authentication) -> response.setStatus(HttpServletResponse.SC_OK)))

                // if login fails, just send an authentication failure response
                .formLogin(formLogin -> formLogin.failureHandler((request, response, authException) -> response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)))

                // if logout is successful, just send a success response
                .logout(logout -> logout.logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()));


        return http.build();
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {

            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        }
    }

}
