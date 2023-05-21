package com.auth.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Component
public class ExceptionHandlingEntryPoint implements AuthenticationEntryPoint {


//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//        // Handle OAuth-related authentication exceptions here
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//    }


    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
//        if (authException instanceof OAuth2AuthenticationException) {
//            OAuth2AuthenticationException oauthException = (OAuth2AuthenticationException) authException;
//            OAuth2Error oauthError = oauthException.getError();
//
//            // Set appropriate HTTP status code and error response based on the OAuth error
//            response.setStatus(oauthError.getHttpStatus().value());
//            response.setContentType("application/json");
//            response.getWriter().write("{\"error\": \"" + oauthError.getErrorCode() + "\", \"message\": \"" + oauthError.getDescription() + "\"}");
//        } else {
//            // Handle other authentication exceptions
//            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
//        }
        final Map<String, Object> mapBodyException = new HashMap<>();

        mapBodyException.put("error", "Error from AuthenticationEntryPoint");
        mapBodyException.put("message", "Message from AuthenticationEntryPoint");
        mapBodyException.put("exception", "My stack trace exception");
        mapBodyException.put("path", request.getServletPath());
        mapBodyException.put("timestamp", (new Date()).getTime());

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        final ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(response.getOutputStream(), mapBodyException);

        //response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }

//    @Override
//    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
//                                        AuthenticationException ex) throws IOException, ServletException {
//        response.setStatus(HttpStatus.FORBIDDEN.value());
//
//        Map<String, Object> data = new HashMap<>();
//        data.put("timestamp", new Date());
//        data.put("status", HttpStatus.FORBIDDEN.value());
//        data.put("message", "Access Denied");
//        data.put("path", request.getRequestURL().toString());
//
//        OutputStream out = response.getOutputStream();
//        com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
//        mapper.writeValue(out, data);
//        out.flush();
//    }




}
