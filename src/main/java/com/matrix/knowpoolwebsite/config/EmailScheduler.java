package com.matrix.knowpoolwebsite.config;

import com.matrix.knowpoolwebsite.service.impl.EmailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    private final EmailServiceImpl emailService;

    @Scheduled(cron = "0 33 18 * * *")
    public void sendEmail() {
        emailService.sendEmailToUsers();
    }
}
