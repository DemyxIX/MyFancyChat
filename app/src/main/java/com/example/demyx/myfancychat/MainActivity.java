package com.example.demyx.myfancychat;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

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
                new Message("a","b"),
                new Message("a","b"),
                new Message("a","b"),
                new Message("a","b"),
                new Message("a","b"),
                new Message("a","b"),
                new Message("a","b")

                );
        //MessageListAdapter mla = new MessageListAdapter(getApplicationContext(),data);
        MessageListAdapter mla = new MessageListAdapter(getApplicationContext(), data);


       ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(mla);
    }
}