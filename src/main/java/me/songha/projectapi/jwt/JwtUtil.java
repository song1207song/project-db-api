package me.songha.projectapi.jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// 참고 : https://oingdaddy.tistory.com/445

@Slf4j
@Component
public class JwtUtil {
    private final String secretKey;
    private final long expireTime;

    public JwtUtil(
            @Value("${app.auth.token-secret}") String secretKey,
            @Value("${app.auth.token-expiry}") long expireTime) {
        this.secretKey = secretKey;
        this.expireTime = expireTime;
    }

    //jwt 생성
    public String buildAccessJwt(Object value, String bodyName) {
        JwtBuilder jwtBuilder = Jwts.builder();
        Map<String, Object> paramMap = new HashMap<>();

        // header
        jwtBuilder.setHeaderParam("alg", SignatureAlgorithm.HS512);

        // payload
        paramMap.put(bodyName, value);
        jwtBuilder.setClaims(paramMap);
        jwtBuilder.setExpiration(new Date(new Date().getTime() + expireTime)); // 만료일

        // signature
        jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey.getBytes());

        return jwtBuilder.compact();
    }

    //jwt 유효성 판단
    public String isValidJwt(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token);
            return "00";   // 유효
        } catch (ExpiredJwtException exception) {
            return "01";   // 만료
        } catch (JwtException exception) {
            return "02";   // 변조
        } catch (Exception e) {
            return "03";   // 그 외 token 오류
        }
    }

    //jwt body부 꺼내기
    public Object getBody(String token, String bodyName) {
        return Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody().get(bodyName);
    }
}