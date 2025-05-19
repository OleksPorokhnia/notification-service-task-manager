package com.alex.project.notoficationsevice.controller;


import com.alex.project.notoficationsevice.model.Message;
import com.alex.project.notoficationsevice.service.MessageMailImpl;
import com.alex.project.notoficationsevice.service.NotificationMailService;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class NotificationController {

    private final SimpMessagingTemplate brokerMessagingTemplate;
    private final MessageMailImpl messageMailImpl;
    private final NotificationMailService notificationMailService;

    public NotificationController(SimpMessagingTemplate brokerMessagingTemplate,
                                  MessageMailImpl messageMailImpl, NotificationMailService notificationMailService) {
        this.brokerMessagingTemplate = brokerMessagingTemplate;
        this.messageMailImpl = messageMailImpl;
        this.notificationMailService = notificationMailService;
    }

    public void sendNotification(Message message) {
        messageMailImpl.sendMessage(notificationMailService.messageConfigurer(message));
        brokerMessagingTemplate.convertAndSend("/topic/notification/" + message.getProjectId(), message);
    }
}
