package com.matrix.knowpoolwebsite;

import com.matrix.knowpoolwebsite.dto.request.RegisterRequest;
import com.matrix.knowpoolwebsite.service.impl.AuthenticationServiceImpl;
import lombok.RequiredArgsConstructor;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Collections;

import static com.matrix.knowpoolwebsite.enumeration.Role.ADMIN;
import static com.matrix.knowpoolwebsite.enumeration.Role.INSTRUCTOR;

@SpringBootApplication
@RequiredArgsConstructor
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class KnowPoolWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowPoolWebsiteApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationServiceImpl service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstName("Admin")
                    .lastName("Admin")
                    .emailAddress("admin@mail.com")
                    .password("password")
                    .roles(Collections.singleton(ADMIN))
                    .build();
            System.out.println("Admin token: " + service.register(admin).getToken());

            var instructor = RegisterRequest.builder()
                    .firstName("Instructor")
                    .lastName("Instructor")
                    .emailAddress("instructor@mail.com")
                    .password("password")
                    .roles(Collections.singleton(INSTRUCTOR))
                    .build();
            System.out.println("Instructor token: " + service.register(instructor).getToken());

        };
    }
}
