package com.example.knowpoolwebsite;

import com.example.knowpoolwebsite.service.impl.EmailService;
import lombok.RequiredArgsConstructor;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@RequiredArgsConstructor
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
public class KnowPoolWebsiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnowPoolWebsiteApplication.class, args);
    }
}
