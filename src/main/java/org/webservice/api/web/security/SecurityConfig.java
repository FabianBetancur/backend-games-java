package org.webservice.api.web.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;
import org.webservice.api.domain.services.UserDetailsService;
import org.webservice.api.web.security.filter.JwtFilterRequest;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtFilterRequest filterRequest;
    private final CorsConfigurationSource corsConfigurationSource;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(AbstractHttpConfigurer::disable)
                .cors(cors->cors.configurationSource(corsConfigurationSource))
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(authorize -> authorize

                        /////////TEST/////////////
                        .requestMatchers(HttpMethod.POST,"/test/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"/test/**").permitAll()
                        /////////AUTH/////////////
                        .requestMatchers(HttpMethod.POST,"/auth/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"/auth/profile").hasAuthority("update_content")
                        /////////USER/////////////
                        .requestMatchers(HttpMethod.GET,"/users/**").hasAnyRole("ADMIN")
                        /////////GAMES/////////////
                        .requestMatchers(HttpMethod.GET,"/games/view").permitAll()
                        .requestMatchers(HttpMethod.GET,"/game/**","/games","/games/**").hasAuthority("update_content")
                        .requestMatchers(HttpMethod.POST,"/game").hasAuthority("update_content")
                        .requestMatchers(HttpMethod.PUT,"/game/**").hasAuthority("update_content")
                        ////////GENRES/////////////
                        .requestMatchers(HttpMethod.GET,"/genres").hasAuthority("update_content")
                        .requestMatchers(HttpMethod.POST,"/genre").hasAuthority("update_content")
                        ////////PLATFORMS//////////
                        .requestMatchers(HttpMethod.GET,"/platforms").hasAuthority("update_content")
                        .requestMatchers(HttpMethod.POST,"/platform").hasAuthority("update_content")
                        ////////INVENTORY//////////
                        .requestMatchers(HttpMethod.GET,"/inventory").hasAuthority("update_content")
                        .requestMatchers(HttpMethod.POST,"/inventory").hasAuthority("update_content")
                        ///////SHORT_URL///////////
                        .requestMatchers(HttpMethod.GET,"/url/**").permitAll()
                        .requestMatchers(HttpMethod.POST,"/shorten").hasAuthority("update_content")
                        //////SHOPPING_CART////////
                        .requestMatchers(HttpMethod.GET,"/cart/**").hasAuthority("update_content")
                        .requestMatchers(HttpMethod.POST,"/cart").hasAuthority("update_content")
                        ////////CART_ITEMS/////////
                        .requestMatchers(HttpMethod.GET,"/cart-items/**").hasAuthority("update_content")
                        .requestMatchers(HttpMethod.POST,"/cart-items").hasAuthority("update_content")
                        ///PAYMENT_TRANSACTIONS////
                        .requestMatchers(HttpMethod.GET,"/transaction/**").hasAuthority("update_content")
                        .requestMatchers(HttpMethod.POST,"/transaction").hasAuthority("update_content")
                        /////////ORDERS////////////
                        .requestMatchers(HttpMethod.GET,"/order/**").hasAuthority("update_content")
                        .requestMatchers(HttpMethod.POST,"/order").hasAuthority("update_content")
                        ////////SWAGGER UI/////////
                        .requestMatchers("/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                )
                .addFilterBefore(filterRequest, UsernamePasswordAuthenticationFilter.class).build();
    }
}