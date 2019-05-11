package com.demo.gpusersapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        reqresApiClientUsage client = new reqresApiClientUsage();
        client.populateUsers(this);

    }

    //Show dialog to add new user when button is pressed
    public void showAddUserDialog(View view)
    {
        
    }
}
