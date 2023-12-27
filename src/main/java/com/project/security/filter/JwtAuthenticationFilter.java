package com.project.security.filter;

import com.project.security.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter; // 1 vez por request

import java.io.IOException;
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    @Autowired
    public JwtAuthenticationFilter(JwtService jwtService,UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService=userDetailsService;
    }


    @Override
    protected void doFilterInternal(
            HttpServletRequest request, //nuestra request
            HttpServletResponse response, // nuestra response
            FilterChain filterChain)
            throws ServletException, IOException {

            final String authHeader = request.getHeader("Authorization");
            final String jwt;
            final String userEmail;
            if (authHeader == null || !authHeader.startsWith("Bearer ")){
                filterChain.doFilter(request,response);
                return;
            }
            jwt = authHeader.substring(7);//Le quitas el 'Bearer '=7 caracteres
            userEmail = jwtService.extractUsername(jwt);
            if( userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = this.userDetailsService.loadUserByUsername(userEmail);
            }
    }
}
