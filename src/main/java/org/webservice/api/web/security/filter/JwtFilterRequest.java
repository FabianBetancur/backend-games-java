package org.webservice.api.web.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.webservice.api.domain.services.UserDetailsService;
import org.webservice.api.domain.services.UserDtoService;
import org.webservice.api.web.security.JwtAuthenticationEntryPoint;
import org.webservice.api.web.security.JwtUtil;

import java.io.IOException;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class JwtFilterRequest extends OncePerRequestFilter {
    private final Log LOGGER = LogFactory.getLog(JwtFilterRequest.class);
    private final JwtUtil jwtUtil;
    private final JwtAuthenticationEntryPoint entryPoint;
    private final UserDetailsService userDetailService;
    private final UserDtoService userDtoService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        LOGGER.info("Filter request...");
        try {
            String token = jwtUtil.resolveToken(request);
            if (token != null && jwtUtil.validateToken(token)) {
                String username = jwtUtil.extractData(token);
                LOGGER.info("JWT valid for user: {" + username + "}");
                UserDetails userDetails = userDetailService
                        .loadUserByUsername(userDtoService.getByEmail(username)
                                .orElseThrow(NoSuchElementException::new).getUserEmail());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails.getUsername(),
                        null,
                        userDetails.getAuthorities()
                );
                authentication.setDetails(
                        new WebAuthenticationDetailsSource()
                                .buildDetails(request)
                );
                SecurityContextHolder.getContext()
                        .setAuthentication(authentication);
            }
        } catch (AuthenticationException ex) {
            LOGGER.error("JWT authentication failed," + ex.getMessage());
            SecurityContextHolder.clearContext();
            entryPoint.commence(request, response, ex);
            return;
        }
        filterChain.doFilter(request, response);
    }
}
