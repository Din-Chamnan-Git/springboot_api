package com.learn.pro1.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JwtUtils jwtUtils;
    private final CustomUserDetailsService userDetailsService;



    public JwtAuthFilter(JwtUtils jwtUtils, CustomUserDetailsService userDetailsService) {
        this.jwtUtils = jwtUtils;
        this.userDetailsService = userDetailsService;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");
        String token = null;
        String email = null;


        // check header for token
        if (header != null && header.startsWith("Bearer ")) {
            token = header.substring(7);

            try {
                email  = jwtUtils.getEmailFromToken(token);
            }catch (Exception e){
                email = null;
            }

        }

        // validate token and set user authentication
        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            //validate token is not expired if expired return null
            if (jwtUtils.validateToken(token)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails
                        , null
                        , userDetails.getAuthorities()
                );

                // set user details in security context
                authToken.setDetails(
                        new WebAuthenticationDetailsSource().buildDetails(request)
                );

                // set authentication in security context
                SecurityContextHolder.getContext().setAuthentication(authToken);

            }
        }

        // continue filter chain
        filterChain.doFilter(request, response);
    }
}
