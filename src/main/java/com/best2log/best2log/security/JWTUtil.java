package com.best2log.best2log.security;



import java.util.Collections;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.best2log.best2log.service.FuncionarioService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTUtil {

    @Value("${jwt.expiration}")
    private Long expiracao;

    @Autowired
    FuncionarioService service;

    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiracao))
                .signWith(SignatureAlgorithm.HS512,"c4f211e9-db2adf4df4f0a390-48c4-8f02-".getBytes())
                .compact();
    }
    static Authentication getAuthentication(HttpServletRequest req){
        String token= req.getHeader("Authorization");
        if(token != null){
            String user= Jwts.parser().setSigningKey("c4f211e9-db2adf4df4f0a390-48c4-8f02-".getBytes())
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();
            if(user != null){
                return new UsernamePasswordAuthenticationToken(user,null, Collections.emptyList());
            }
        }
        return null;
    }
    public String getRole(String token){
        if(token != null){
            String user= Jwts.parser().setSigningKey("c4f211e9-db2adf4df4f0a390-48c4-8f02-".getBytes())
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();
            if(user != null){
               return user.split("-")[1];
            }
        }
        return null;


    }
    public String getCPF(String token){
        if(token != null){
            String user= Jwts.parser().setSigningKey("c4f211e9-db2adf4df4f0a390-48c4-8f02-".getBytes())
                    .parseClaimsJws(token.replace("Bearer ", ""))
                    .getBody()
                    .getSubject();
            if(user != null){
                return user.split("-")[0];
            }
        }
        return null;


    }

    }

