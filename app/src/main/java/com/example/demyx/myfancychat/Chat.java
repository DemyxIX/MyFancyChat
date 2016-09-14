package com.example.demyx.myfancychat;

import java.util.ArrayList;

/**
 * Created by Demyx-Laptop on 02.09.2016.
 */

public class Chat {
    ArrayList<Message> msgs;

    public Chat(ArrayList<Message> msgs) {
        this.msgs = msgs;
    }

    public ArrayList<Message> getMsgs() {
        return msgs;
    }
}
