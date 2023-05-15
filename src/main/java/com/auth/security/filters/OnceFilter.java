package com.auth.security.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Component
@Order(1)
public class OnceFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Basic ")) {
            String encodedCredentials = authorizationHeader.substring(6).trim();
            String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials), StandardCharsets.UTF_8);
            
            // Split the decoded credentials into username and password
            String[] credentialsArray = decodedCredentials.split(":", 2);
            String username = credentialsArray[0];
            String password = credentialsArray[1];

            // Use the username and password as needed
            // ...



//            String username = "your-username";
//            String password = "your-password";
//
//            String encodedCredentials = Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
//
//            String authorizationHeader = "Basic " + encodedCredentials;
//            request.setHeader("Authorization", authorizationHeader);



        }

        filterChain.doFilter(request, response);
    }
}
