package com.auth.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomLogoutHandler implements LogoutSuccessHandler  {

	//private final static Logger LOGGER = Logger.getLogger(LogoutImpl.class);
	
	private VcasheTokenStore  vcasheTokenStore;
	
	
//	public VcasheTokenStore getTokenStore() {
//		return vcasheTokenStore;
//	}


	public void setTokenStore(VcasheTokenStore vcasheTokenStore) {
		this.vcasheTokenStore = vcasheTokenStore;
	}


	@Override
	public void onLogoutSuccess(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse,
			Authentication paramAuthentication) throws IOException,
			ServletException {
		removeAccess(paramHttpServletRequest);
		SecurityContextHolder.clearContext();
		paramHttpServletResponse.getOutputStream().write("\n\tYou Have Logged Out successfully.".getBytes());
		
	}
	
	
public void removeAccess(HttpServletRequest req){
		
		String tokens = req.getHeader("Authorization");
		//LOGGER.debug(" Authorization Header: "+tokens);
		if(tokens != null) {
			String value=tokens.substring(tokens.indexOf(" ")).trim(); 
			DefaultOAuth2AccessToken token= new DefaultOAuth2AccessToken(value);
			//LOGGER.debug(" token: "+token);
			System.out.println( " Token VALue: "+value);
			vcasheTokenStore.removeAccessToken(value);
			vcasheTokenStore.removeRefreshToken(value);
			//LOGGER.debug("\n\tAccess Token Removed Successfully!!!!!!!!");
		} else {
			//LOGGER.warn(" #### invalid Logout Request!");
		}
		
		
	}

}