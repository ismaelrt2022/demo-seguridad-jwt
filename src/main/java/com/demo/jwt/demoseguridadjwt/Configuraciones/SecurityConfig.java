package com.demo.jwt.demoseguridadjwt.Configuraciones;

import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.RequiredArgsConstructor;

@Configuration  //Indica que vamos a usar BEAN en los metosdos
@EnableWebSecurity
@RequiredArgsConstructor  
public class SecurityConfig {
    
    //Creacion de metodos para restringir
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http 
       .csrf(csrf->     //Deshabilitamos este modo de authenticacions
        csrf.disable())
        .authorizeHttpRequests(authRequest->
       authRequest
       .requestMatchers("/auth/**").permitAll()
       .anyRequest().authenticated()
         )
       // .formLogin(withDefaults())  //se comentariza la seguridad de spring security y usaremos ahora jwt
       .sessionManagement(sessionManager->
       sessionManager
       .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
       .authenticationProvider(authProvider)
       .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)  
       .build();
    }           

}
