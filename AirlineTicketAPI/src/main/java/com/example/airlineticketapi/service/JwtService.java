package com.example.airlineticketapi.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService
{
    @Value("${security.jwt-expire-date}")
    private long expirationDate;
    @Value("${security.jwt.secret-key}")
    private String secretKey;

    public String extractUsername(String token)
    {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver)
    {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(String username)
    {
        return generateToken(new HashMap<>(), username);
    }

    public String generateToken(Map<String, Object> extraClaims, String username)
    {
        return buildToken(extraClaims, username, expirationDate);
    }


    private String buildToken(Map<String, Object> extraClaims, String username, long expiration)
    {
        return Jwts
                .builder()
                .claims(extraClaims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), Jwts.SIG.HS256)
                .compact();
    }

    public boolean isTokenValid(String token, String uname)
    {
        String username = extractUsername(token);
        return (username.equals(uname)) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token)
    {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token)
    {
        return Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload();
    }

    public SecretKey getSignInKey()
    {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
