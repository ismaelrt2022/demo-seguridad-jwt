package com.demo.jwt.demoseguridadjwt.Controladores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class DemoController {

    //endpoint seguro
    
    @PostMapping(value="demo")
    public String welcome(){
     
        return "Welcome form secure endpoint";
    }
}
