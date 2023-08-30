package com.tkgroupbd.pusti.api.seeders;

import com.tkgroupbd.pusti.api.data.models.enums.Role;
import com.tkgroupbd.pusti.api.data.models.entity.user.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import com.tkgroupbd.pusti.api.data.repositories.user.UserRepository;

@Component
public class DatabaseSeeder {
    private UserRepository userRepository;

    @Autowired
    public DatabaseSeeder(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    @EventListener
    public void seed(ContextRefreshedEvent event) {
        seedUsersTable();
    }

    public void seedUsersTable() {
        if (userRepository.count() == 0) {
            User user = new User();
            user.setEmail("admin@techknowgram.com");
            user.setFirstname("John");
            user.setLastname("Wright");
            user.setPassword("password");
            user.setRole(Role.ADMIN);
            userRepository.save(user);
        }
    }
}
