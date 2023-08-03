package com.example.knowpoolwebsite.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;
//    @Value("${mail.from}")
//    private String from;
//    @Value("${mail.to}")
//    private String to;

    @Scheduled(cron = "0 12 12 * * *") // Send email every hour (in milliseconds)
    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailProperties.getFrom());
        message.setTo(mailProperties.getTo());
        message.setSubject(mailProperties.getSubject());
        message.setText(mailProperties.getText());

        javaMailSender.send(message);
        System.out.println("Email sent successfully!");
    }
}
