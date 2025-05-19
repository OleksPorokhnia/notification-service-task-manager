package com.alex.project.notoficationsevice.service;

import com.alex.project.notoficationsevice.controller.NotificationController;
import com.alex.project.notoficationsevice.model.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
    private final NotificationController notificationController;

    public NotificationConsumer(NotificationController notificationController) {
        this.notificationController = notificationController;
    }

    @KafkaListener(topics = "${topic.name}", groupId = "notification-group")
    public void listen(Message message) {
        System.out.println("Notification Consumer received a message" + message.getProjectId() + " " + message.getMessage());
        notificationController.sendNotification(message);
    }
}
