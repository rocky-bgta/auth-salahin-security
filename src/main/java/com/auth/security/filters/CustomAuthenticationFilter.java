package com.auth.security.filters;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public CustomAuthenticationFilter(RequestMatcher requestMatcher) {
        super(requestMatcher);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                              AuthenticationException failed) throws IOException, ServletException {
        //if (failed.getCause() instanceof RecordNotFoundException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, failed.getMessage());
        //}
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        // Extract the necessary information from the request (e.g., username and password)
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform your authentication logic here (e.g., validating credentials against a database)
        if (isValidUser(username, password)) {
            // Create an authenticated token for the user
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);

            // Return the authenticated token
            return getAuthenticationManager().authenticate(authentication);
        } else {
            // Throw an authentication exception if the credentials are invalid
            throw new BadCredentialsException("Invalid credentials");
        }
    }

    private boolean isValidUser(String username, String password) {
        // Implement your custom logic to validate the user credentials
        // For example, you can check against a database or an external service
        // Return true if the credentials are valid, false otherwise
        // Replace this with your own implementation
        return username.equals("admin") && password.equals("password");
    }
}
