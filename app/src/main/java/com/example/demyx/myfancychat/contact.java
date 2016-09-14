package com.example.demyx.myfancychat;

import android.net.Uri;

/**
 * Created by Demyx-Laptop on 02.09.2016.
 */

public class Contact {

    private String name;
    private int number;
    private int ID;
    private Uri photoUri;

    public Contact(String name, int number, int ContactId, Uri photoUri) {
        this.name = name;
        this.number = number;
        this.ID = ContactId;
        this.photoUri = photoUri;

    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getID() {
        return ID;
    }

    public Uri getPhotoUri() {
        return photoUri;
    }
}