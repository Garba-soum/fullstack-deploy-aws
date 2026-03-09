package com.example.clientcommande.config;

import com.example.clientcommande.model.AppUser;
import com.example.clientcommande.model.Role;
import com.example.clientcommande.repository.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AppUserRepository appUserRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        String adminUsername = "admin";

        if (appUserRepository.findByUsername(adminUsername).isEmpty()) {
            AppUser admin = new AppUser();
            admin.setUsername(adminUsername);
            admin.setPassword(passwordEncoder.encode("admin123"));
            admin.setRole(Role.ADMIN);

            appUserRepository.save(admin);

            System.out.println(">>> Admin créé : admin / admin123");
        } else {
            System.out.println(">>> Admin déjà présent en base.");
        }
    }
}