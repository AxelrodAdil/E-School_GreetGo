package com.example.eschool_greetgo.repo;

import com.example.eschool_greetgo.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    public Long countById(Integer id);

    @Query("select u from User u where u.email = ?1")
    User findUserByEmail(String email);
}