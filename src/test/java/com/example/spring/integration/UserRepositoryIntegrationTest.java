package com.example.spring.integration;


import com.example.spring.entities.Users;
import com.example.spring.repositories.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void whenFindByUsername_thenReturnUser() {
        // given
        Users user_1 = new Users((long) 1, "Leanne Graham", "Bret", "Sincere@april.biz", "password", false, "USER");
        entityManager.persist(user_1);
        entityManager.flush();
        // when
        Optional<Users> found = userRepository.findByUsername(user_1.getUsername());
        // then
        assertThat(found.isPresent())
                .isEqualTo(true);
        assertThat(found.get().getUsername())
                .isEqualTo(user_1.getUsername());
    }
}