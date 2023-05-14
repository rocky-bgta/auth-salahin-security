package com.auth.security.service;


import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

	private static final String MOBILE_APP_CLIENT = "casheApp";
	private static final String MOBILE_APP_SECRET = "casheAppSecret";
	
	private static final String ADMIN_APP_CLIENT = "casheAdmin";
	private static final String ADMIN_APP_SECRET = "casheAdminSecret";

	//private String resourceId;
	private List<String> resourceIds = new ArrayList<>();

	public ClientDetailsServiceImpl(String resourceId){
		resourceIds.add(resourceId);
	}
	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws OAuth2Exception {

		if (clientId.equals(MOBILE_APP_CLIENT)) {
			
			List<String> authorizedGrantTypes=new ArrayList<String>();
			authorizedGrantTypes.add("password");
			authorizedGrantTypes.add("refresh_token");
			authorizedGrantTypes.add("client_credentials");
		
			BaseClientDetails clientDetails = new BaseClientDetails();
			clientDetails.setClientId(MOBILE_APP_CLIENT);
			clientDetails.setClientSecret(MOBILE_APP_SECRET);
			clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
			clientDetails.setResourceIds(resourceIds);
			
			return clientDetails;
			
		} else if(clientId.equals(ADMIN_APP_CLIENT)){
			
			List<String> authorizedGrantTypes=new ArrayList<String>();
			authorizedGrantTypes.add("password");
			authorizedGrantTypes.add("refresh_token");
			authorizedGrantTypes.add("client_credentials");
			
			
			BaseClientDetails clientDetails = new BaseClientDetails();
			clientDetails.setClientId(ADMIN_APP_CLIENT);
			clientDetails.setClientSecret(ADMIN_APP_SECRET);
			clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
			clientDetails.setResourceIds(resourceIds);
			return clientDetails;
		}
		
		
		else{
			throw new NoSuchClientException("No client with requested id: "
					+ clientId);
		}
	}

}
