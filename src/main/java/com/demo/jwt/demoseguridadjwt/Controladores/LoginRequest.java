package com.demo.jwt.demoseguridadjwt.Controladores;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * LoginRequest  Realizar solicitudes
 */

 @Data
 @Builder
 @AllArgsConstructor
 @NoArgsConstructor
public class LoginRequest {

    String username;
    String password;

    
}