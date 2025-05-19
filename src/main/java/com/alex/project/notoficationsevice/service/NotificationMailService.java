package com.alex.project.notoficationsevice.service;

import com.alex.project.notoficationsevice.model.Message;
import org.springframework.stereotype.Service;

@Service
public class NotificationMailService {

    public Message messageConfigurer(Message message) {
        String mainMessage = message.getMessage();

        String stringBuilder = "Dear " + message.getUserEmail() +
                "\n" +
                mainMessage;

        message.setMessage(stringBuilder);

        return message;
    }
}
