package com.example.pibapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NewsActivity extends AppCompatActivity {
    TextView ministry,posted_by,matter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("News_pib");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        ministry = findViewById(R.id.ministry);
        posted_by = findViewById(R.id.Posted_by);
        matter = findViewById(R.id.matter);
        Bundle b = getIntent().getExtras();
        String value = ""; // or other values
        String id = "";
        if(b != null){

            value = b.getString("val");
            id = b.getString("key");
        }

        myRef.child(value).child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ministry.setText(snapshot.child("Ministry").getValue().toString());
                posted_by.setText("Posted by "+snapshot.child("Posted by").getValue().toString() +" On "+snapshot.child("Date").getValue().toString());
                matter.setText(snapshot.child("Description").getValue().toString());
//                Toast.makeText(NewsActivity.this, snapshot.child("Posted by").getValue().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }
}