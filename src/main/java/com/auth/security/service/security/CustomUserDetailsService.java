package com.auth.security.service.security;

import com.auth.security.entites.UserRole;
import com.auth.security.entites.Users;
import com.auth.security.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username);
        List<SimpleGrantedAuthority> roleList;
        Set<UserRole> userRoles = users.getUserRole();
        roleList = getAuthorities(userRoles);
        return new User(users.getUsername(), users.getPassword(), roleList);
    }

    private List<SimpleGrantedAuthority> getAuthorities(Set<UserRole> userRoles) {
        List<SimpleGrantedAuthority> roleList = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            roleList.add(new SimpleGrantedAuthority(getRoleName(userRole.getRole().getRolesName())));
        }
        return roleList;
    }

    private String getRoleName(String role) {
        if (role.equalsIgnoreCase("admin")) {
            return "ROLE_ADMIN";
        } else if (role.equalsIgnoreCase("customer")) {
            return "ROLE_CUSTOMER";
        } else if (role.equalsIgnoreCase("superadmin")) {
            return "ROLE_SUPERADMIN";
        } else if (role.equalsIgnoreCase("read_only")) {
            return "ROLE_READ_ONLY";
        } else if (role.equalsIgnoreCase("customer_support")) {
            return "ROLE_CUST_SUPPORT";
        } else if (role.equalsIgnoreCase("ops")) {
            return "ROLE_OPS";
        } else if (role.equalsIgnoreCase("supervisor")) {
            return "ROLE_SUPERVISOR";
        } else if (role.equalsIgnoreCase("dsa")) {
            return "ROLE_DSA";
        } else if (role.equalsIgnoreCase("andromeda")) {
            return "ROLE_ANDROMEDA";
        } else if (role.equalsIgnoreCase("sales")) {
            return "ROLE_SALES";
        } else if (role.equalsIgnoreCase("growth_supervisor")) {
            return "ROLE_GROWTH_SUPERVISOR";
        } else if (role.equalsIgnoreCase("campaignuser")) {
            return "ROLE_CAMPAIGN";
        } else if (role.equalsIgnoreCase("cashe_dev")) {
            return "ROLE_CASHE_DEV";
        } else if (role.equalsIgnoreCase("prod_support")) {
            return "ROLE_PROD_SUPPORT";
        } else if (role.equalsIgnoreCase("collections")) {
            return "ROLE_COLLECTIONS";
        } else if (role.equalsIgnoreCase("receivable_supervisor")) {
            return "ROLE_RECEIVABLE_SUPERVISOR";
        } else if (role.equalsIgnoreCase("overdue_supervisor")) {
            return "ROLE_OVERDUE_SUPERVISOR";
        } else if (role.equalsIgnoreCase("collections_supervisor")) {
            return "ROLE_COLLECTIONS_SUPERVISOR";
        } else if (role.equalsIgnoreCase("receivable_agent")) {
            return "ROLE_RECEIVABLE_AGENT";
        } else if (role.equalsIgnoreCase("overdue_agent")) {
            return "ROLE_OVERDUE_AGENT";
        } else if (role.equalsIgnoreCase("growth_admin")) {
            return "ROLE_GROWTH_ADMIN";
        } else if (role.equalsIgnoreCase("QC_Supervisor")) {
            return "ROLE_QC_SUPERVISOR";
        } else if (role.equalsIgnoreCase("support")) {
            return "ROLE_SUPPORT";
        }
        return null;
    }
}

