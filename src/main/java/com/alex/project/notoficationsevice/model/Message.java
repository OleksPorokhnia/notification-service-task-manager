package com.alex.project.notoficationsevice.model;

public class Message {
    private String theme;
    private String message;
    private int projectId;
    private String userEmail;

    public Message() {
    }

    public Message(String theme, String message, int projectId, String userEmail) {
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
