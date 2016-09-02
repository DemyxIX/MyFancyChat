package com.example.demyx.myfancychat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Demyx-Laptop on 01.09.2016.
 */

public class Message implements Serializable {
    String user;
    String message;
    Date timestapm;

    public Message(String message, String user) {
        this.message = message;
        this.user = user;
        this.timestapm = new Date();
    }

    public String getUser() {
        return user;
    }

    public String getMessage() {
        return message;
    }

    public Date getTimestapm() {
        return timestapm;
    }
}
