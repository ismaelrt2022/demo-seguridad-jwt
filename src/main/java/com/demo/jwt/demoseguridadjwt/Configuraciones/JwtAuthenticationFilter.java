package com.demo.jwt.demoseguridadjwt.Configuraciones;

import java.io.IOException;
//import java.net.http.HttpHeaders;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//Usar como component y heredar para la clase abstracta para utilizar sus metodos de filtro personalizado y
//Garantizar que el filtro se utilice 1 vez por peticion

@Component
public class JwtAuthenticationFilter  extends OncePerRequestFilter{


    //Implementar metodo doFilterInternal  para personalizar los filtros

    //Solicitudes, rspuestas y cadena de filtros filterchain le regresamos 

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'doFilterInternal'");

        final String token =getTokenFromRequest(request);

                if(token ==null )
                {
                    filterChain.doFilter(request, response);
                    return;
                }
                filterChain.doFilter(request, response);
    }   



    private String getTokenFromRequest(HttpServletRequest request) {
   final String authHeader =request.getHeader(HttpHeaders.AUTHORIZATION);

   if(authHeader != null && authHeader.startsWith("Bearer ")){

        return authHeader.substring(7);
    }
    
    return null;

}


}