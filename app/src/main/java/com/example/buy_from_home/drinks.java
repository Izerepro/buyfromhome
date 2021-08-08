package com.example.buy_from_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class drinks extends AppCompatActivity {
    Button locationball, ballohome;
    ImageButton callballo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baguma);
        locationball=findViewById(R.id.locationball);
        callballo=findViewById(R.id.callballo);
        ballohome=findViewById(R.id.ballohome);
        locationball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), locate.class);
                startActivity(intent);
            }
        });
        callballo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), make_call.class);
                startActivity(intent);
            }
        });
        ballohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sign_in.class);
                startActivity(intent);
            }
        });
    }
}