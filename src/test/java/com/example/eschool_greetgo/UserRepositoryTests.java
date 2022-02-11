package com.example.eschool_greetgo;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.eschool_greetgo.model.User;
import com.example.eschool_greetgo.repo.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("adil1@mail.com");
        user.setPassword("adil");
        user.setFirstName("Adil");
        user.setLastName("Myktybek");

        //https://stackoverflow.com/questions/68381105/the-junit-test-not-autowired-my-service-class-but-it-works-in-the-controller

        User saveUser = userRepository.save(user);
        assertThat(saveUser).isNotNull();
        assertThat(saveUser.getId()).isGreaterThan(0);
    }

    @Test
    public void testListAll(){
        userRepository.findAll();
    }

    @Test
    public void testFindUserByEmail(){
        String email = "adil@mail.com";
        User user = userRepository.findUserByEmail(email);
        assertThat(user).isNotNull();
    }
}