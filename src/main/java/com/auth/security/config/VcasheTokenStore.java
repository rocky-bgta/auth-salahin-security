package com.auth.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.stereotype.Component;

@Component
public class VcasheTokenStore {

    @Autowired
    private JdbcTokenStore tokenStore;

    @Autowired
    @Qualifier(value = "vcasheClientDetails")
    ClientDetailsService clientDetailsService;

    @Value("${support_refresh_token}")
    private boolean supportRefreshToken;

    @Value("${access_token_expiry_time}")
    private int accessTokenValiditySeconds;

//    private ResourceServerTokenServices resourceServerTokenServices() {
//        DefaultTokenServices tokenServices = new DefaultTokenServices();
//        tokenServices.setTokenStore(tokenStore);
//        tokenServices.setSupportRefreshToken(supportRefreshToken);
//        tokenServices.setAccessTokenValiditySeconds(accessTokenValiditySeconds);
//        tokenServices.setClientDetailsService(clientDetailsService);
//        return tokenServices;
//    }

    public DefaultTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(tokenStore);
        tokenServices.setSupportRefreshToken(supportRefreshToken);
        tokenServices.setAccessTokenValiditySeconds(accessTokenValiditySeconds);
        tokenServices.setClientDetailsService(clientDetailsService);
        return tokenServices;
    }
}
