package com.project.security.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY="vt1b1WGrujL4q4gEXcMMQpPXfUnuV6Sn";
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails){
        return  Jwts
                .builder() //
                .setClaims(extraClaims) // extra claims es para pasar cualquier informacion que queremos guradar ene l token
                .setSubject(userDetails.getUsername())  // metemos el username como subject
                .setIssuedAt(new Date(System.currentTimeMillis())) // cuando se creo el token
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *24)) //expiracion del token
                .signWith(getSignInKey(), SignatureAlgorithm.HS256) // firma el token
                .compact(); // compacta el token, lo genera y lo devuelve
    }

    public Boolean isTokenValid(String token,UserDetails userDetails){
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractTokenExpiration(token).before(new Date());
    }

    private Date extractTokenExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }


    public <T> T extractClaim (String token, Function<Claims,  T> claimsResolver){
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }





    public Claims extractAllClaims(String token){
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }



    private Key getSignInKey() {
        byte[] KeyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(KeyBytes);
    }
}
