package com.binar.challenge4.notif;

public class NotifRequest {
    private String title;
    private String message;
    private String detail;
    private String token;


    public NotifRequest() {
        super();
    }


    public NotifRequest(String title, String message, String detail, String token) {
        super();
        this.title = title;
        this.message = message;
        this.detail = detail;
        this.token = token;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getTopic() {
        return detail;
    }
    public void setTopic(String topic) {
        this.detail = topic;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
