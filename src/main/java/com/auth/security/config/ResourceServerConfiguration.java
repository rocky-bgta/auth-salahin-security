package com.auth.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.ClientCredentialsTokenEndpointFilter;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "myrestservice";

    @Autowired
    @Qualifier(value = "vcasheClientAuthenticationEntryPoint")
    private OAuth2AuthenticationEntryPoint clientAuthenticationEntryPoint;

    @Autowired
    @Qualifier(value = "vcasheClientCredentialsTokenEndpointFilter")
    ClientCredentialsTokenEndpointFilter clientCredentialsTokenEndpointFilter;

    @Autowired
    OAuth2AccessDeniedHandler oauthAccessDeniedHandler;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers("/admin/*")
                .hasAnyRole("ADMIN")
                .antMatchers("/hello/*")
                .authenticated();

        http
                .csrf().disable()
                .anonymous().disable()
                .httpBasic().authenticationEntryPoint(clientAuthenticationEntryPoint)
                .and()
                .addFilterBefore(clientCredentialsTokenEndpointFilter, BasicAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(oauthAccessDeniedHandler)
                .and()
                .headers()
                .frameOptions().policy(FrameOptionsHeaderWriter.DenyHeaderWriter.X_FRAME_OPTIONS)
                .cacheControl().disable()
                .contentTypeOptions().disable()
                .httpStrictTransportSecurity().disable()
                .xssProtection().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/token").fullyAuthenticated();
    }
}
