package com.alex.project.notoficationsevice.service;

import com.alex.project.notoficationsevice.model.Message;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import java.util.List;

public class MessageMailImpl implements MessageManager{
    private MailSender mailSender;
    private SimpleMailMessage simpleMailMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
        this.simpleMailMessage = simpleMailMessage;
    }

    @Override
    public void sendMessage(Message message) {
        SimpleMailMessage msg = new SimpleMailMessage(this.simpleMailMessage);
        msg.setTo(message.getUserEmail().stream().toString());
        msg.setText(message.getMessage());

        try{
            this.mailSender.send(msg);
        }catch (MailException e) {
            System.err.println(e.getMessage());
        }
    }
}
