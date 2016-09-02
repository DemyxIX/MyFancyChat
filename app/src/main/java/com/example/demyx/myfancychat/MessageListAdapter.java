package com.example.demyx.myfancychat;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.R.id.message;

/**
 * Created by Demyx-Laptop on 01.09.2016.
 */

public class MessageListAdapter extends ArrayAdapter<Message> {
    public MessageListAdapter(Context context, List<Message> messageList) {
        super(context, 0, messageList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = getItem(position);

        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.message_layout,parent,false);
        }

        ImageView person = (ImageView)convertView.findViewById(R.id.imageView);
        //person.getBackground();
        TextView messageView = (TextView)convertView.findViewById(R.id.textView);
        messageView.setText(message.getMessage()+ ": "+message.getTimestapm());

        return convertView;
    }
}