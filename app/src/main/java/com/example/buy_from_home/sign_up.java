package com.example.buy_from_home;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class sign_up extends AppCompatActivity {
    private EditText emailEditText, passwordEditText, confirmPasswordEditText;
    private Button register1, register2;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        firebaseAuth=FirebaseAuth.getInstance();
        emailEditText =findViewById(R.id.email);
        passwordEditText =findViewById(R.id.password1);
        confirmPasswordEditText =findViewById(R.id.password2);
        register1 = findViewById(R.id.register1);
        register2 = findViewById(R.id.register2);
        progressDialog=new ProgressDialog(this);
        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });

        register2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), sign_in.class);
                startActivity(intent);
            }
        });
    }
    private void Register() {
        String email = emailEditText.getText().toString();
        String password1 = passwordEditText.getText().toString();
        String password2 = confirmPasswordEditText.getText().toString();
        if (TextUtils.isEmpty(email)) {
            emailEditText.setError("enter your email");
            return;
        } else if (TextUtils.isEmpty(password1)) {
            emailEditText.setError("enter your password");
            return;
        } else if (TextUtils.isEmpty(password2)) {
            emailEditText.setError("verify your password");
            return;
        } else if (!password1.equals(password2)) {
            confirmPasswordEditText.setError("wrong password");
            return;
        } else if (password1.length() < 8) {
            passwordEditText.setError("add on password");
            return;
        } else if (!isValidEmail(email)){
            emailEditText.setError("enter valide email");
            return;
        }
        progressDialog.setMessage("please wait");
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
        firebaseAuth.createUserWithEmailAndPassword(email,password1);
        startActivity(new Intent(this,sign_in.class));
    }
    private Boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

}