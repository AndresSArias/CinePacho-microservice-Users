package com.pragma.powerup.usermicroservice.configuration.security;

import com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.adapter.UserDetailsServiceImpl;
import com.pragma.powerup.usermicroservice.configuration.security.jwt.JwtEntryPoint;
import com.pragma.powerup.usermicroservice.configuration.security.jwt.JwtTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class MainSecurity {

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    private final JwtEntryPoint jwtEntryPoint;

    public MainSecurity(JwtEntryPoint jwtEntryPoint) {
        this.jwtEntryPoint = jwtEntryPoint;
    }


    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(
            AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests(requests -> requests
                        .requestMatchers("/auth/login","/auth/refresh", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**","/user/createUserCustomer").permitAll()
                        .requestMatchers("/users/all/admins").hasRole("DIRECTOR")
                        .requestMatchers("/users/getUser/{numberDocument}").hasAnyRole("EMPLOYEE","ADMIN", "DIRECTOR")
                        .anyRequest().authenticated()
                )
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}
