package com.example.buy_from_home;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button button;
    private Locale.Builder builder;
    private String languages;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),sign_in.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.languages, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int itemId=item.getItemId();

        if(itemId==R.id.action_english){
            setLocale("");


        }
        else if(itemId==R.id.action_french){
            setLocale("fr");
        }
        else if(itemId==R.id.action_swahili){
            setLocale("sw-rKE");
        }
        else{
            setLocale("");
        }
        return super.onOptionsItemSelected(item);
    }

    public void setLocale(String language){
        Locale locale=new Locale(language);
        Locale.setDefault(locale);
        Configuration configuration=new Configuration();
        configuration.locale=locale;
        getBaseContext().getResources().updateConfiguration(configuration, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor=getSharedPreferences("my_prefs", Context.MODE_PRIVATE).edit();
        editor.putString("language",language);
        editor.apply();
    }
    public void checkLanguage(){
        SharedPreferences preferences=getSharedPreferences("my_prefs", Context.MODE_PRIVATE);
        String language=preferences.getString("language", "");
        setLocale(language);
    }
    public void open_language_dialog(View view){
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        String languages[]={getResources().getString(R.string.english), getResources().getString(R.string.french), getResources().getString(R.string.swahili)};
        builder.setTitle("select language");
        builder.setSingleChoiceItems(languages, - 1, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface option, int which) {
                if (which == 0) {
                    setLocale("");
                    recreate();
                } else if (which == 1) {
                    setLocale("fr");
                    recreate();
                } else if (which ==2) {
                    setLocale("sw-rKE");
                    recreate();
                }


            }
        });
        AlertDialog dialog=builder.create();
        dialog.show();





    }
}


