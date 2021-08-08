package com.example.buy_from_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class transport extends AppCompatActivity {
    Button dbtn, dbtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        dbtn=findViewById(R.id.dbtn);
        dbtn1=findViewById(R.id.dbtn1);
        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), locate.class);
                startActivity(intent);
            }
        });
        dbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), locate.class);
                startActivity(intent);
            }
        });
    }
}