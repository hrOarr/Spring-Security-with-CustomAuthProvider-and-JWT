package com.astrodust.springsecurity;

import com.astrodust.springsecurity.entity.Role;
import com.astrodust.springsecurity.entity.User;
import com.astrodust.springsecurity.enums.RoleEnum;
import com.astrodust.springsecurity.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService){
        return args -> {
          User user1 = new User("admin", "testAdmin@gmail.com", passwordEncoder().encode("123456"));
          user1.getRoles().add(new Role(RoleEnum.ADMIN));
          User user2 = new User("user", "testUser@gmail.com", passwordEncoder().encode("123456"));
          user2.getRoles().add(new Role(RoleEnum.USER));
          User user3 = new User("moderator", "testMod@gmail.com", passwordEncoder().encode("123456"));
          user3.getRoles().add(new Role(RoleEnum.MODERATOR));
          userService.saveOrUpdate(user1);
          userService.saveOrUpdate(user2);
          userService.saveOrUpdate(user3);
        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
