package com.demo.pocketpal.configs;


import com.demo.pocketpal.configs.jwt.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class FilterChainConfig {
    private final JwtAuthFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    private static final String[] WHITELIST = {
            "/auth/**",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    };


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                // requests below do not need authentication.
                .authorizeHttpRequests(auth -> auth.requestMatchers(WHITELIST)
                        .permitAll()
                // requests below require certain roles to access content. (Order matters!)
                .requestMatchers("/admin/**")
                .hasRole("ADMIN")
                .requestMatchers("/person/**")
                .hasAnyRole("ADMIN")
                .requestMatchers("/**")
                .hasAnyRole("ADMIN","USER")
                // all other requests require authentication.
                .anyRequest()
                .authenticated()
                )
                // authentication should not be stored thus stateless session.
                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // show spring which authentication provider to use.
                .authenticationProvider(authenticationProvider)
                // to execute our custom filter before UsernamePasswordAuthenticationFilter, this allows us to set securityContext with our filter.
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }


}
