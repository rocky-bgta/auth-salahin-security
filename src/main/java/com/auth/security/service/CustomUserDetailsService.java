package com.auth.security.service;

import com.auth.security.entites.UserRole;
import com.auth.security.entites.Users;
import com.auth.security.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepository.findByUsername(username);
        List<SimpleGrantedAuthority> roleList = new ArrayList<>();
        Set<UserRole> userRoles = users.getUserRole();
        for (UserRole userRole : userRoles) {
            roleList.add(new SimpleGrantedAuthority(userRole.getRole().getRolesName()));
        }

        return new User(users.getUsername(), users.getPassword(), roleList);
    }
}

