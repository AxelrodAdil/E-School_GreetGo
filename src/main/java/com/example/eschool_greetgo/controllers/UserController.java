/*package com.example.eschool_greetgo.controllers;

import com.example.eschool_greetgo.mapper.mapper_main;
import com.example.eschool_greetgo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private mapper_main mapper_main;

    public UserController (mapper_main mapper_main){
        this.mapper_main = mapper_main;
    }

    @GetMapping(value = "/users")
    public List<User> findAll(){
        return mapper_main.findAll();
    }

    @PostMapping(value = "/users/add")
    public List<User> add(@RequestBody User user_){
        User user = user_;
        mapper_main.insert(user);
        return mapper_main.findAll();
    }

    @PostMapping(value = "/users/update/{id}")
    private List<User> update(@RequestBody User user_){
        User user = user_;
        mapper_main.update(user);
        return mapper_main.findAll();
    }

    @DeleteMapping(value = "/users/delete/{id}")
    private List<User> delete(@PathVariable Integer id){
        mapper_main.delete(id);
        return mapper_main.findAll();
    }
}*/