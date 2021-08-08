package com.example.buy_from_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class baguma extends AppCompatActivity {
    Button location, baghome;
    ImageButton call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baguma);
        location=findViewById(R.id.location);
        call=findViewById(R.id.call);
        baghome=findViewById(R.id.baghome);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), locate.class);
                startActivity(intent);
                            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), make_call.class);
                startActivity(intent);
            }
        });
        baghome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sign_in.class);
                startActivity(intent);
            }
        });
    }
}