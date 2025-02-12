package com.github.lucasmartins.task_lister.infrastructure.config.security.filter;

import com.github.lucasmartins.task_lister.infrastructure.config.security.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    private final UserDetailsService userDetailsService;

    public JwtTokenFilter(JwtService jwtService, UserDetailsService userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);
            return;
        }
        final String bearer = authHeader.substring(7);
        final String username = jwtService.extractUsername(bearer);
        Optional.of(username)
                .ifPresent(name -> autenticate(request, name, bearer));
        filterChain.doFilter(request, response);
    }

    private void autenticate(HttpServletRequest request, String username, String bearer) {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            return;
        }
        final UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);
        if (!jwtService.isTokenValid(bearer, userDetails)) {
            return;
        }
        final UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                userDetails, null, userDetails.getAuthorities()
        );
        authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authToken);

    }

}
