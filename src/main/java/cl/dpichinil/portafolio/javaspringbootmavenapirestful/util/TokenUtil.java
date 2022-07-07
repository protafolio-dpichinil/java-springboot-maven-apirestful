package cl.dpichinil.portafolio.javaspringbootmavenapirestful.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@UtilityClass
public class TokenUtil {
    private static Long defaultExpiration;

    public static Long setDefaultExpiration(Long defaultExpiration) {
        return TokenUtil.defaultExpiration = defaultExpiration;
    }

    public static String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username = claims.getSubject();
            if (username == null) username = "";
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public static Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private static Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(Constant.KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private static Date generateExpirationDate() {
        long expirationMillis = 0L;
        expirationMillis = defaultExpiration * 1000;
        return new Date(System.currentTimeMillis() + expirationMillis);
    }

    private static Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public static String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(Constant.CLAIM_KEY_USERNAME, username);
        claims.put(Constant.CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    private static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, Constant.KEY)
                .compact();
    }

    public static String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(Constant.CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public static int validateToken(String token) {
        int resp = 1000;
        if (!isTokenExpired(token)) {
            resp = 0;
        } else {
            resp = 1001;
        }
        return resp;
    }
}
