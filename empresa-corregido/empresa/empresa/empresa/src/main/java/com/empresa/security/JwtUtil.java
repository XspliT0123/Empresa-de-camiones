package com.empresa.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey clave = Keys.hmacShaKeyFor(
            "clave-secreta-para-clase-jwt-2024!!".getBytes()
    );

    private static final long DURACION_MS = 1000 * 60 * 60; // 1 hora

    public String generarToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + DURACION_MS))
                .signWith(clave)
                .compact();
    }

    public String extraerUsername(String token) {
        return Jwts.parser()
                .verifyWith(clave)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean esValido(String token) {
        try {
            Jwts.parser().verifyWith(clave).build().parseSignedClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }
}
