
package com.demo.jwt.demoseguridadjwt.Controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

    //  Metodos no protegidos publicos
    
    @PostMapping(value = "login")
   public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request){
      return ResponseEntity.ok(authService.login(request));
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request){
      return ResponseEntity.ok(authService.register(request));
    }
   
   
   
   /* public String login(){
      return "Login from public enpoint ";
    }

    @PostMapping(value = "register")
    public String register(){
        return "Register from public endpoint";
    }

    */
}
