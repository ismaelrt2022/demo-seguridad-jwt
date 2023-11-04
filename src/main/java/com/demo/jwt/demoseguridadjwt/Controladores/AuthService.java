package com.demo.jwt.demoseguridadjwt.Controladores;

import org.apache.catalina.authenticator.SpnegoAuthenticator.AuthenticateAction;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthenticatedAuthorizationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.demo.jwt.demoseguridadjwt.Entidades.Role;
import com.demo.jwt.demoseguridadjwt.Entidades.User;
import com.demo.jwt.demoseguridadjwt.Servicios.JwtService;

import lombok.RequiredArgsConstructor;
    

@Service
@RequiredArgsConstructor
public class AuthService  {


    private final UserRepository  userRepository;
    private final JwtService  jwtService;
    private final PasswordEncoder  passwordEncoder;
    private final AuthenticationManager authenticationManager;   //----LOGIN

    public AuthResponse login(LoginRequest request){
        //return null;

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        UserDetails user =userRepository.findByUsername(request.getUsername()); //.orElseThrow();
        String Token=jwtService.getToken(user);
        return AuthResponse.builder()
        .token(Token)
        .build();
    }

    public AuthResponse register(RegisterRequest request){
        User user = User.builder()
        .username(request.getUsername())
        .password(passwordEncoder.encode(request.getPassword()))
        .firstname(request.getFirstname())
        .lastname(request.getLastname())
        .country(request.getCountry())
        .role(Role.USER)
        .build();

        userRepository.save(user);


        return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .build();
    }
    


}

