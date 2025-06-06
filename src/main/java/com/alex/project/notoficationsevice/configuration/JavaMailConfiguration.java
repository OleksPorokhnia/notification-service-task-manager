package com.alex.project.notoficationsevice.configuration;

import com.alex.project.notoficationsevice.service.MessageMailImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class JavaMailConfiguration {
    @Bean
    JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("sashaporohnya76@gmail.com");
        mailSender.setPassword("unyh buax wnai ohpz");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        return mailSender;
    }

    @Bean
    SimpleMailMessage templateMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sashaporohnya76@gmail.com");
        message.setSubject("Task beaerer notification");
        return message;
    }

    @Bean
    MessageMailImpl messageManager() {
        MessageMailImpl messageManager = new MessageMailImpl();
        messageManager.setMailSender(mailSender());
        messageManager.setSimpleMailMessage(templateMessage());
        return messageManager;
    }

}
