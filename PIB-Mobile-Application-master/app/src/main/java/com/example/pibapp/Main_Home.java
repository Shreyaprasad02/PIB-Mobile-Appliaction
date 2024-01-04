package com.example.pibapp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main_Home extends AppCompatActivity {

    TextView home,settings,profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_home);
        getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new Home()).commit();
        home = findViewById(R.id.homepage);
        settings = findViewById(R.id.aboutpage);
        profile = findViewById(R.id.profilepage);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new Home()).commit();

            }
        });
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new Settings()).commit();

            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_container,new Profile_Fragment()).commit();

            }
        });

    }
}