package com.auth.security.beans;

import com.auth.security.config.CustomUserAuthenticationProvider;
import com.auth.security.service.ClientDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;

import java.util.Arrays;

@Configuration
@PropertySource({ "classpath:application.properties" })
public class WebBeans {
    private static final String RESOURCE_ID = "myrestservice";
    @Bean(name = "vcasheClientDetails")
    public ClientDetailsServiceImpl clientDetails() {
        return new ClientDetailsServiceImpl(RESOURCE_ID);
    }

    @Bean(name = "vcasheAuthenticationProvider")
    public CustomUserAuthenticationProvider customUserAuthenticationProvider() {
        CustomUserAuthenticationProvider authenticationProvider = new CustomUserAuthenticationProvider();
        //authenticationProvider.setLoginDao(loginDao());
        return authenticationProvider;
    }

    @Bean(name = "vcasheAuthenticationManager")
    public AuthenticationManager authenticationManager() {
        AuthenticationProvider authenticationProvider = new CustomUserAuthenticationProvider();
        return new ProviderManager(Arrays.asList(authenticationProvider));
    }

    @Bean(name = "vcasheClientCredentialsTokenEndpointFilter")
    public ClientCredentialsTokenEndpointFilter clientCredentialsTokenEndpointFilter() {
        ClientCredentialsTokenEndpointFilter filter = new ClientCredentialsTokenEndpointFilter();
        filter.setAuthenticationManager(authenticationManager());
        return filter;
    }

    @Bean(name = "vcasheClientAuthenticationEntryPoint")
    public OAuth2AuthenticationEntryPoint oAuth2ClientAuthenticationEntryPointBean() {
        OAuth2AuthenticationEntryPoint entryPoint = new OAuth2AuthenticationEntryPoint();
        entryPoint.setRealmName("springsec/client");
        entryPoint.setTypeName("Basic");
        return entryPoint;
    }

    @Bean
    public OAuth2AccessDeniedHandler oauthAccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler();
    }
}
