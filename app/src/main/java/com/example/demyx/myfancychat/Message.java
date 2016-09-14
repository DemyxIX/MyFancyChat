package com.example.demyx.myfancychat;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Demyx-Laptop on 01.09.2016.
 */

public class Message implements Serializable {
    Contact sender;
    Contact reciver;
    String message;
    Date timestapm;

    public Message(String message, Contact from, Contact to) {
        this.message = message;
        this.sender = from;
        this.reciver = to;
        this.timestapm = new Date();
    }

    public Contact getSender() {
        return sender;
    }

    public Contact getReciver() { return reciver; }

    public String getMessage() {
        return message;
    }

    public Date getTimestapm() {
        return timestapm;
    }
}
