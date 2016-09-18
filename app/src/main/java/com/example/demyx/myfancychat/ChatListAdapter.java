package com.example.demyx.myfancychat;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Demyx-Laptop on 16.09.2016.
 */


public class ChatListAdapter extends ArrayAdapter<List<Message>> {
    public ChatListAdapter(Context context, List<List<Message>> messageList) {
        super(context, 0, messageList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final List<Message> messageList =getItem(position);
        //Message message = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message_layout,parent,false);
        }

        if(messageList.size()>0) {
            Message last = messageList.get(messageList.size() - 1);

            ImageView person = (ImageView) convertView.findViewById(R.id.imageView);
            person.setImageURI(Uri.parse(last.getSender().getPhotoUri()));
            TextView messageView = (TextView) convertView.findViewById(R.id.textView);

            if(last.getSender().getName().equals("Me")){
                person.setImageURI(Uri.parse(last.getReciver().getPhotoUri()));
                messageView.setText(last.getReciver().getName() +" : " + last.getReciver().getNumber() + ": " + last.getMessage());
            } else{
            messageView.setText(last.getSender().getName() + " : " + last.getSender().getNumber() + ": " + last.getMessage());
            }
        }
        return convertView;
    }
}