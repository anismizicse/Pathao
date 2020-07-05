package com.ourdreamit.pathao.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import com.ourdreamit.pathao.R;
import com.ourdreamit.pathao.broadcastreceivers.InternetDetector;
import com.ourdreamit.pathao.services.CountingService;

public class HomeScreen extends AppCompatActivity {

    TextView phoneContacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        phoneContacts = findViewById(R.id.phoneContacts);

        //Broadcast Receiver
        InternetDetector internetDetector = new InternetDetector();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(internetDetector, intentFilter);
    }

    //Start Long Running Operation
    public void startLongService(View view){
        Intent intent = new Intent(this, CountingService.class);
        startService(intent);
    }

    //Read contacts from Phone app.
    public void readPhoneContacts(View view) {

        StringBuilder contactsBuilder = new StringBuilder("");

        String[] projection = {
                ContactsContract.Contacts.DISPLAY_NAME_PRIMARY
        };

        ContentResolver contentResolver = getContentResolver();
        Cursor cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,projection,
                null,null,null);

        if(cursor != null && cursor.getCount() > 0){
            while (cursor.moveToNext()){
                contactsBuilder.append(cursor.getString(0)+"\n");
            }
        }

        phoneContacts.setText(contactsBuilder.toString());

    }
}