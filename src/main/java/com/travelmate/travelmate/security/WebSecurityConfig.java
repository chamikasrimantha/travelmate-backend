package com.travelmate.travelmate.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.travelmate.travelmate.security.jwt.AuthEntryPoint;
import com.travelmate.travelmate.security.jwt.AuthTokenFilter;

@Configuration
@EnableMethodSecurity
public class WebSecurityConfig {

    @Autowired
    private AuthEntryPoint unauthorizedHandler;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public UserDetailsService userDetailsService() {
        return userDetailsService;
    }

    @Bean
    public AuthTokenFilter authenticationJwTokenFilter() {
        return new AuthTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf(csrf -> csrf.disable())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/user/register",
                                "/auth/user/login",
                                "/auth/partner/register",
                                "/auth/partner/login",
                                "/auth/admin/register/**",
                                "/auth/admin/login",
                                // "/users/**",
                                // "/partners/**",
                                // "/admins/**",
                                "/provinces/**",
                                "/districts/**",
                                "/cities/**",
                                "/city-ratings/**",
                                "/property-ratings/**",
                                "/properties/**",
                                "/categories/**",
                                "/admin-announcements/**",
                                "/partner-announcements/**",
                                "/chat/**",
                                // "/bookings/**",
                                "/v3/api-docs/**",
                                "v3/api-docs.yaml",
                                "/swagger-ui/**",
                                "/swagger-ui.html")
                        .permitAll()
                        .requestMatchers("/auth/admin/**").hasRole("ADMIN")
                        .requestMatchers("/auth/partner/**").hasRole("PARTNER")
                        .requestMatchers("/auth/user/**").hasRole("USER")
                        .anyRequest().authenticated());

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwTokenFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

}
