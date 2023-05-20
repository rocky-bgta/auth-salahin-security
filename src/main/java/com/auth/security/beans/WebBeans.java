package com.auth.security.beans;


import com.auth.security.config.CustomLogoutHandler;
import com.auth.security.config.CustomPasswordEncoder;
import com.auth.security.config.VcasheTokenStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
//@PropertySource({ "classpath:application.properties" })
public class WebBeans {
//    @Bean
//    public BCryptPasswordEncoder encoder(){
//        return new BCryptPasswordEncoder();
//    }

    @Autowired
    private VcasheTokenStore vcasheTokenStore;

    @Bean
    public PasswordEncoder passwordEncoder() {
        CustomPasswordEncoder customPasswordEncoder = new CustomPasswordEncoder();
        return customPasswordEncoder;
    }

    @Bean
    public CustomLogoutHandler customLogoutHandler(){
        CustomLogoutHandler customLogoutHandler = new CustomLogoutHandler();
        customLogoutHandler.setTokenStore(vcasheTokenStore);
        return customLogoutHandler;
    }

}
