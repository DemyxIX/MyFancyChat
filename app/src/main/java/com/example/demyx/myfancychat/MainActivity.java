package com.example.demyx.myfancychat;


import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URI;
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
    private ArrayList<Chat> chats = new ArrayList<Chat>();
    private ArrayList<Contact> contacts = new ArrayList<Contact>();
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    private Contact me = null;
    private ArrayList<Message> msgs = new ArrayList<Message>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        askToMake();

        //List data = Arrays.asList(
                /*new Message("when", "Tom"),
                new Message("who", "Fred"),
                new Message("?", "me"),
                new Message("how", "Nina"),
                new Message("what", "Dave"),*/
                for(int i=0; i<contacts.size(); i++){
                msgs.add(new Message("test",contacts.get(i)));
        }

        //);
        final MessageListAdapter mla = new MessageListAdapter(getApplicationContext(), msgs);


        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(mla);


        final EditText sendText = (EditText) findViewById(R.id.messageText);
        final ImageButton sendButton = (ImageButton) findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick (View view){
                                              if(sendText.getText().length() != 0){
                                                  mla.add(new Message(sendText.getText().toString(), me));
                                                  mla.notifyDataSetChanged();
                                                  sendText.getText().clear();


                                              }
                                          }

                                      }
        );
    }


    private void askToMake() {
        // Check the SDK version and whether the permission is already granted or not.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.READ_CONTACTS}, PERMISSIONS_REQUEST_READ_CONTACTS);
            //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method
        } else {
            // Android version is lesser than 6.0 or the permission is already granted.
            createContacts();

        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {
        if (requestCode == PERMISSIONS_REQUEST_READ_CONTACTS) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                createContacts();
            } else {
                Toast.makeText(this, "Until you grant the permission, we canot display the names", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void createContacts(){


        ContentResolver cr = getContentResolver();
        // Get the Cursor of all the contacts
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);

        // Move the cursor to first. Also check whether the cursor is empty or not.
        if (cursor.moveToFirst()) {
            // Iterate through the cursor
            do {
                // Get the contacts name
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                int number = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts.PHONETIC_NAME));
                int ID = cursor.getInt(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                Uri photoUri = null;
                //Uri photoUri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI,ContactsContract.Contacts.PHOTO_FILE_ID);
                if(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI)) != null){
                    photoUri = Uri.parse(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.PHOTO_URI)));
                }
                else{
                    photoUri = new Uri.Builder().build();
                }

                    contacts.add(new Contact(name, number, ID, photoUri));

                    if (name.equals("Me")) {
                        me = (Contact) contacts.get(((contacts.size()) - 1));
                    }



            }
                while (cursor.moveToNext()) ;
            }
            // Close the curosor
            cursor.close();



    }
}
