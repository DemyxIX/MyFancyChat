package com.example.demyx.myfancychat;


import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.example.demyx.myfancychat.R.id.messageText;
import static com.example.demyx.myfancychat.R.id.sendButton;

public class MainActivity extends AppCompatActivity {


   /* public void clickFunction(View view) {
        EditText myTextField = (EditText) findViewById(R.id.extField);
        Log.i("Info", myTextField.getText().toString());
    }*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List data = Arrays.asList(
                new Message("when", "Tom"),
                new Message("who", "Fred"),
                new Message("how", "Nina"),
                new Message("what", "Dave")

        );
        final MessageListAdapter mla = new MessageListAdapter(getApplicationContext(), new ArrayList(data));


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mla);


        final EditText sendText = (EditText) findViewById(R.id.messageText);
        final ImageButton sendButton = (ImageButton) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick (View view){
                                              if(sendText.getText().length() != 0){
                                                  mla.add(new Message(sendText.getText().toString(), "me"));
                                                  mla.notifyDataSetChanged();
                                                  sendText.getText().clear();


                                              }
                                          }

                                      }
        );
    }

}
