package org.example.jwtspringsecurity.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.example.jwtspringsecurity.dto.JwtResponse;
import org.example.jwtspringsecurity.dto.RefreshTokenRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtService {

    @Value("${MY_APP_SECRET}")
    private String mySecret;


    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public JwtResponse generateToken(String username) {                                                 //{ 1 }
        Map<String, Object> clamis = new HashMap<>();
        return createToken(clamis, username);
    }

    private JwtResponse createToken(Map<String, Object> clamis, String username) {                      //{ 2 }
        String accessToken = Jwts.builder()
                .setClaims(clamis)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 2))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

        String refreshToken = Jwts.builder()
                .setClaims(clamis)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 9))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();

        return new JwtResponse(accessToken, refreshToken);
    }

    public Boolean validateToken(String token, UserDetails userDetails) {                               // { 3 }
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {                                                     // { 4 }
        return extractExpiration(token).before(new Date());
    }


    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(mySecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public JwtResponse createRefreshToken(RefreshTokenRequest refreshTokenRequest) {
        String token = refreshTokenRequest.getToken();
        String userName = extractUsername(token);
        JwtResponse jwtResponse = generateToken(userName);
        return jwtResponse;
    }

}
