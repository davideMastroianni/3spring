package com.example.spring;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Users((long) 1, "Leanne Graham", "Bret", "Sincere@april.biz")));
            log.info("Preloading " + repository.save(new Users((long) 2, "Ervin Howell", "Antonette", "Shanna@melissa.tv")));
        };
    }
}
