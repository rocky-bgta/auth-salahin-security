package com.auth.security.repository;


import com.auth.security.entites.Users;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends CrudRepository<Users,Integer> {

    Users findByUsername(String name);

}
