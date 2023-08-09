package com.matrix.knowpoolwebsite.config;

import lombok.Data;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mail")
@Data
public class MailProperties {
    private String from;
    private String subject;
    private String text;
}
