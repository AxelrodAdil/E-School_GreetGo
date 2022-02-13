package com.example.eschool_greetgo;

import com.example.eschool_greetgo.model.User;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(User.class)
@MapperScan("com.example.eschool_greetgo.mapper")
@SpringBootApplication
public class ESchoolGreetgoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ESchoolGreetgoApplication.class, args);
    }
}