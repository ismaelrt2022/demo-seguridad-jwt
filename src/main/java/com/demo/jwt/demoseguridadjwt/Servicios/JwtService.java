package com.demo.jwt.demoseguridadjwt.Servicios;

import java.security.Key;
import java.security.Signature;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {


    private final static String SECRET_KEY="586E3272357538782F413F4428472B4B6250655368566B597033733676397924";
    
    public String getToken(UserDetails user){
        return getToken(new HashMap<>(),user);

    }


    private  String getToken(Map<String,Object> extraClaims,UserDetails user){
        
            return Jwts
            .builder()
            .setClaims(extraClaims)
            .setSubject(user.getUsername())
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
            .signWith(getkey(),SignatureAlgorithm.HS256)
            .compact();

    }

    private Key getkey(){

        byte[] keyBytes=Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
    }
}
