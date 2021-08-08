package com.example.buy_from_home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class twine extends AppCompatActivity {
    Button locationtw, twinhome;
    ImageButton calltwin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baguma);
        locationtw=findViewById(R.id.locationtw);
        calltwin=findViewById(R.id.calltwin);
        twinhome=findViewById(R.id.twinhome);
        locationtw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), locate.class);
                startActivity(intent);
            }
        });
        calltwin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), make_call.class);
                startActivity(intent);
            }
        });
        twinhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), sign_in.class);
                startActivity(intent);
            }
        });
    }
}