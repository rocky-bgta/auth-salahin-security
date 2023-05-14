package com.auth.security.repository;

import com.auth.security.entites.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Integer> {

    User findByName(String name);

}
