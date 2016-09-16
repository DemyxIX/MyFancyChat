package com.example.demyx.myfancychat;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by Demyx-Laptop on 02.09.2016.
 */

public class Contact implements Serializable {

    private String name;
    private String number;
    private int ID;
    private String photoUri;

    public Contact(String name, String number, int ContactId, String photoUri) {
        this.name = name;
        this.number = number;
        this.ID = ContactId;
        this.photoUri = photoUri;

    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public int getID() {
        return ID;
    }

    public String getPhotoUri() {
        return photoUri;
    }
}