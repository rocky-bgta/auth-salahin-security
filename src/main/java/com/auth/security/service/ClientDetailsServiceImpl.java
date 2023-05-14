package com.auth.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.NoSuchClientException;
import org.springframework.security.oauth2.provider.client.BaseClientDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ClientDetailsServiceImpl implements ClientDetailsService {

	@Autowired
	BCryptPasswordEncoder encoder;
	private static final String MOBILE_APP_CLIENT = "myClientApp";
	private static final String MOBILE_APP_SECRET = "9999";
	
	private static final String ADMIN_APP_CLIENT = "myClientApp";
	private static final String ADMIN_APP_SECRET = "9999";

	//private String resourceId;
	private List<String> resourceIds = new ArrayList<>();
	List<String> scope = new ArrayList<>();

	public void setResourceId(String givenResourceId) {
		resourceIds.add(givenResourceId);
	}

	public ClientDetailsServiceImpl(){
		scope.add("read");
		scope.add("write");
		scope.add("trust");

	}

	
	@Override
	public ClientDetails loadClientByClientId(String clientId) throws OAuth2Exception {


		List<String> authorizedGrantTypes=new ArrayList<>();
		authorizedGrantTypes.add("password");
		authorizedGrantTypes.add("refresh_token");
		authorizedGrantTypes.add("client_credentials");

		if (clientId.equals(MOBILE_APP_CLIENT)) {
			BaseClientDetails clientDetails = new BaseClientDetails();
			clientDetails.setClientId(MOBILE_APP_CLIENT);
			clientDetails.setClientSecret(encoder.encode(MOBILE_APP_SECRET));
			clientDetails.setAuthorizedGrantTypes(authorizedGrantTypes);
			clientDetails.setScope(scope);
			clientDetails.setResourceIds(resourceIds);
			return clientDetails;
			
		} else if(clientId.equals(ADMIN_APP_CLIENT)){
			BaseClientDetails clientDetails = new BaseClientDetails();
			clientDetails.setClientId(ADMIN_APP_CLIENT);
			clientDetails.setClientSecret(encoder.encode(ADMIN_APP_SECRET));
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
