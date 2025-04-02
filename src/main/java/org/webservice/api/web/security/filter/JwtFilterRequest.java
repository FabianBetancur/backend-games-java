package org.webservice.api.web.security.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

@Component
public class JwtFilterRequest extends OncePerRequestFilter {
    private final Log LOGGER = LogFactory.getLog(JwtFilterRequest.class);
    private final JwtUtil jwtUtil;
    private final JwtAuthenticationEntryPoint entryPoint;
    private final UserDetailsService userDetailService;
    private final UserDtoService userDtoService;

    @Autowired
    public JwtFilterRequest(JwtUtil jwtUtil, JwtAuthenticationEntryPoint entryPoint, UserDetailsService userDetailService, UserDtoService userDtoService){
        this.jwtUtil = jwtUtil;
        this.entryPoint = entryPoint;
        this.userDetailService = userDetailService;
        this.userDtoService = userDtoService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        LOGGER.info("Filter request...");
        try {
            String token  = jwtUtil.resolveToken(request);
            if(token != null && jwtUtil.validateToken(token)){
                LOGGER.info("Filter request :: loading by user name...");
                UserDetails userDetails = userDetailService.loadUserByUsername(userDtoService.findByUserId(Long.parseLong(jwtUtil.extractId(token))).get().getUserEmail());
                LOGGER.info("Filter request :: user email: " + userDetails.getUsername());
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
                LOGGER.info("Filter request :: authentication: " + authentication);
            }
        } catch (AuthenticationException ex){
            LOGGER.error("filter request :: exception: " + ex.getMessage());
            SecurityContextHolder.clearContext();
            entryPoint.commence(request,response,ex);
            return;
        }
        filterChain.doFilter(request,response);
    }
}
