package me.songha.projectapi.jwt;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final String headerKey;

    public JwtFilter(JwtUtil jwtUtil, @Value("${app.auth.header-key}") String headerKey) {
        this.jwtUtil = jwtUtil;
        this.headerKey = headerKey;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        String token = httpServletRequest.getHeader(headerKey);
        String result = jwtUtil.isValidJwt(token);

        if ("00".equals(result)) {
            Object body = jwtUtil.getBody(token, "body");
            httpServletRequest.setAttribute("body", body);
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        } else if ("01".equals(result)) {
            log.info("=================================== expired");
        } else {
            log.info("=================================== something wrong");
        }
    }
}