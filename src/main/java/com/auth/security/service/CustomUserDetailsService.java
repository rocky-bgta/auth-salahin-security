package com.auth.security.service;

import com.auth.security.entites.Role;
import com.auth.security.entites.User;
import com.auth.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken( user.getName(),  user.getPassword(), user.getRoles());
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        return  getUserDetails(user.getName(), user.getPassword(), user.getRoles());
    }

    private UserDetails getUserDetails(String username, String password, Set<Role> roles){
        return new org.springframework.security.core.userdetails.User
                (username, password, roles);
    }
}
