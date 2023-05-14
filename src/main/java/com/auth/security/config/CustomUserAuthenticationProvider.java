package com.auth.security.config;


import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserAuthenticationProvider implements AuthenticationProvider {
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        CustomUserPasswordAuthenticationToken auth = new CustomUserPasswordAuthenticationToken(
                authentication.getPrincipal(),
                authentication.getCredentials(), getAuthorities("superadmin"));

        return auth;

    }

    public boolean supports(Class<? extends Object> authentication) {

        return true;
    }

    private Collection<? extends GrantedAuthority> getAuthorities(String role) {
        List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));
        return authList;
    }

    private List<String> getRoles(String role) {
        List<String> roles = new ArrayList<String>();
        if (role.equalsIgnoreCase("admin")) {
            roles.add("ROLE_ADMIN");
        } else if (role.equalsIgnoreCase("customer")) {
            roles.add("ROLE_CUSTOMER");
        } else if (role.equalsIgnoreCase("customer_support")) {
            roles.add("ROLE_CUST_SUPPORT");
        } else if (role.equalsIgnoreCase("ops")) {
            roles.add("ROLE_OPS");
        } else if (role.equalsIgnoreCase("supervisor")) {
            roles.add("ROLE_SUPERVISOR");
        } else if (role.equalsIgnoreCase("dsa")) {
            roles.add("ROLE_DSA");
        } else if (role.equalsIgnoreCase("read_only")) {
            roles.add("ROLE_READ_ONLY");
        } else if (role.equalsIgnoreCase("andromeda")) {
            roles.add("ROLE_ANDROMEDA");
        } else if (role.equalsIgnoreCase("sales")) {
            roles.add("ROLE_SALES");
        } else if (role.equalsIgnoreCase("growth_supervisor")) {
            roles.add("ROLE_GROWTH_SUPERVISOR");
        } else if (role.equalsIgnoreCase("superadmin")) {
            roles.add("ROLE_SUPERADMIN");
        } else if (role.equalsIgnoreCase("campaignuser")) {
            roles.add("ROLE_CAMPAIGN");
        } else if (role.equalsIgnoreCase("cashe_dev")) {
            roles.add("ROLE_CASHE_DEV");
        } else if (role.equalsIgnoreCase("prod_support")) {
            roles.add("ROLE_PROD_SUPPORT");
        } else if (role.equalsIgnoreCase("collections")) {
            roles.add("ROLE_COLLECTIONS");
        } else if (role.equalsIgnoreCase("receivable_supervisor")) {
            roles.add("ROLE_RECEIVABLE_SUPERVISOR");
        } else if (role.equalsIgnoreCase("overdue_supervisor")) {
            roles.add("ROLE_OVERDUE_SUPERVISOR");
        } else if (role.equalsIgnoreCase("collections_supervisor")) {
            roles.add("ROLE_COLLECTIONS_SUPERVISOR");
        } else if (role.equalsIgnoreCase("receivable_agent")) {
            roles.add("ROLE_RECEIVABLE_AGENT");
        } else if (role.equalsIgnoreCase("overdue_agent")) {
            roles.add("ROLE_OVERDUE_AGENT");
        } else if (role.equalsIgnoreCase("growth_admin")) {
            roles.add("ROLE_GROWTH_ADMIN");
        } else if (role.equalsIgnoreCase("QC_Supervisor")) {
            roles.add("ROLE_QC_SUPERVISOR");
        }
        return roles;
    }

    private static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        return authorities;
    }

}
