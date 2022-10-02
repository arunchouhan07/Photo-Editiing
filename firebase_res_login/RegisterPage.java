package com.example.firebase_res_login;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.service.autofill.UserData;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterPage extends AppCompatActivity {
EditText name,email,password,phone,city;
Button register;
FirebaseAuth fireAuth;
DatabaseReference databaseReference;
FirebaseDatabase database;
DataHolder dataHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        phone=findViewById(R.id.phone);
        city=findViewById(R.id.city);
        register=findViewById(R.id.register);

        database=FirebaseDatabase.getInstance();
        databaseReference = database.getReference();
        fireAuth= FirebaseAuth.getInstance();

        register.setOnClickListener(View->{
            String user_name=name.getText().toString();
            String user_email=email.getText().toString();
            String user_password=password.getText().toString();
            String user_phone=phone.getText().toString();
            String user_city=city.getText().toString();

            dataHolder=new DataHolder(user_name,user_phone,user_city);
            databaseReference.child("User Details").setValue(dataHolder);

            fireAuth.createUserWithEmailAndPassword(user_email, user_password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(RegisterPage.this, "Register Successfull...", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterPage.this,LogIn.class));
                            } else {
                                Toast.makeText(RegisterPage.this, "Register Failed!!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            name.getText().clear();
            email.getText().clear();
            password.getText().clear();
            phone.getText().clear();
            city.getText().clear();
        });

    }
}