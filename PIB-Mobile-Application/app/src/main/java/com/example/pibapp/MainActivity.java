package com.example.pibapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Thread thread = new Thread(){

            @SuppressLint("ResourceType")
            public void run(){
                try {
                    sleep(2000);

                }catch (Exception e){
                    e.printStackTrace();
                }
                finally {

                    Intent intent = new Intent(MainActivity.this,Login.class);
                    startActivity(intent);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragment()).commit();

                }
                finish();
            }
        };thread.start();

    }
}