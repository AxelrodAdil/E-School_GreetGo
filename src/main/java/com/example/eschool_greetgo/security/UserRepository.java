package com.example.eschool_greetgo.security;

import com.example.eschool_greetgo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {  // only for Spring Security
    @Query("select u from User u where u.email = ?1")
    User findUserByEmail(String email);
}