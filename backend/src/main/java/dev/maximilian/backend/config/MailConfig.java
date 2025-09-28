package dev.maximilian.backend.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class MailConfig {

    @Value("${spring.mail.host}")
    private String HOST;
    @Value("${spring.mail.port}")
    private Integer PORT;
    @Value("${spring.mail.username}")
    private String USERNAME;
    @Value("${spring.mail.password}")
    private String PASSWORD;
    @Value("${spring.mail.properties.mail.transport.protocol}")
    private String PROTOCOL;
    @Value("${spring.mail.properties.mail.smtp.auth}")
    private String AUTH;
    @Value("${spring.mail.properties.mail.smtp.starttls.required}")
    private String STARTTLS_REQUIRED;
    @Value("${spring.mail.properties.mail.smtp.starttls.enable}")
    private String STARTTLS_ENABLE;

    @Bean
    JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(HOST);
        mailSender.setPort(PORT);
        mailSender.setUsername(USERNAME);
        mailSender.setPassword(PASSWORD);

        Properties properties = mailSender.getJavaMailProperties();
        properties.put("mail.transport.protocol", PROTOCOL);
        properties.put("mail.smtp.auth", AUTH);
        properties.put("mail.smtp.starttls.enable", STARTTLS_REQUIRED);
        properties.put("mail.smtp.starttls.enable", STARTTLS_ENABLE);

        return mailSender;
    }

}
