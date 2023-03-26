package com.example.a1click;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {
    TextView name;
    StartActivity start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        name = (TextView) findViewById(R.id.name);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }
}