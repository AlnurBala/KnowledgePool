package com.matrix.knowpoolwebsite.service.impl;

import com.matrix.knowpoolwebsite.config.MailProperties;
import com.matrix.knowpoolwebsite.entity.User;
import com.matrix.knowpoolwebsite.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl {
    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private final MailProperties mailProperties;

    public void sendEmailToUsers() {
        List<User> users = userRepository.findAll();

        for (User user : users) {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mailProperties.getFrom());
            message.setTo(user.getEmailAddress());
            message.setSubject(mailProperties.getSubject());
            message.setText(mailProperties.getText());

            javaMailSender.send(message);
        }

        System.out.println("Emails sent to all users successfully!");
    }
}
