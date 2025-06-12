package com.alex.project.notoficationsevice.model;

import org.apache.kafka.common.protocol.types.Field;

import java.util.List;

public class Message {
    private String theme;
    private String message;
    private String projectId;
    private List<String> userEmail;

    public Message() {
    }

    public Message(String theme, String message, String projectId, List<String> userEmail) {
        this.theme = theme;
        this.message = message;
        this.projectId = projectId;
        this.userEmail = userEmail;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<String> getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(List<String> userEmail) {
        this.userEmail = userEmail;
    }
}
