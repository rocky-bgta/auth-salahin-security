package com.auth.security.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class LogoutImpl implements LogoutSuccessHandler  {

	//private final static Logger LOGGER = Logger.getLogger(LogoutImpl.class);
	
	JdbcTokenStore  tokenstore;
	
	
	public JdbcTokenStore getTokenstore() {
		return tokenstore;
	}


	public void setTokenstore(JdbcTokenStore tokenstore) {
		this.tokenstore = tokenstore;
	}


	@Override
	public void onLogoutSuccess(HttpServletRequest paramHttpServletRequest,
			HttpServletResponse paramHttpServletResponse,
			Authentication paramAuthentication) throws IOException,
			ServletException {
		removeaccess(paramHttpServletRequest);
		paramHttpServletResponse.getOutputStream().write("\n\tYou Have Logged Out successfully.".getBytes());
		
	}
	
	
public void removeaccess(HttpServletRequest req){
		
		String tokens = req.getHeader("Authorization");
		//LOGGER.debug(" Authorization Header: "+tokens);
		if(tokens != null) {
			String value=tokens.substring(tokens.indexOf(" ")).trim(); 
			//DefaultOAuth2AccessToken token= new DefaultOAuth2AccessToken(value);
			//LOGGER.debug(" token: "+token);
			System.out.println( " Token VALue: "+value);
			//tokenstore.removeAccessToken(value);
			//tokenstore.removeRefreshToken(value);
			//LOGGER.debug("\n\tAccess Token Removed Successfully!!!!!!!!");
		} else {
			//LOGGER.warn(" #### invalid Logout Request!");
		}
		
		
	}

}