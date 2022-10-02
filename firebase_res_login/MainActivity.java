package com.example.firebase_res_login;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
   Button signUp,logIn;
   ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp=findViewById(R.id.signUp);
        logIn=findViewById(R.id.logIn);
        imageView=findViewById(R.id.imageView);

        signUp.setOnClickListener(View->{
            startActivity(new Intent(MainActivity.this,RegisterPage.class));
        });

        logIn.setOnClickListener(View->{
            startActivity(new Intent(MainActivity.this,LogIn.class));
        });

    }
}