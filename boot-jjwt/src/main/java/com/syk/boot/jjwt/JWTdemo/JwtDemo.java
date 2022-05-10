package com.syk.boot.jjwt.JWTdemo;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author 沈永康
 * @Date 2022/4/21 20:19
 * @Version 1.0
 */


public class JwtDemo {
    private final static String SECRET = "123456789";

    public static String createJwtToken() {
        Map<String,Object> header = new HashMap<>(4);
        header.put("alg","HS265");
        header.put("typ","JWT");

        Map<String,Object>  claims = new HashMap<>(8);
        claims.put("iss","syk");
        claims.put("id","222");
        claims.put("userName","admin");



        return  Jwts.builder()
                .setHeader(header)
                .setClaims(claims)
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 36 * 1000))
                .setSubject("TOM")
                .signWith(SignatureAlgorithm.HS256,SECRET)
                .compact();
    }

    public static Claims getClaimsFromJwt(String jwt){
    return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(jwt).getBody();

    }

    public static void main(String[] args) {
        String jwtToken = createJwtToken();
        System.out.println("JWT Token: " + jwtToken);
        System.out.println("==================");
        Claims claims = getClaimsFromJwt(jwtToken);
        System.out.println("claims" + claims);
    }
}
