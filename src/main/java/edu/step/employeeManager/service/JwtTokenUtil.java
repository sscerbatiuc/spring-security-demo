package edu.step.employeeManager.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    public static int JWT_VALIDITY = 5 * 60 * 60 * 1000;
    public static String KEY = "step";

    public String generateToken(String username){
        Map<String, Object> claims = new HashMap<>();
        // TODO: rolurile utilizatorului


        return Jwts.builder()
                .setSubject(username)
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + JWT_VALIDITY))
                .signWith(SignatureAlgorithm.HS512, KEY)
                .compact();
    }

    public Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJwt(token).getBody();
    }
}
