package com.example.firebase_res_login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Welcome extends AppCompatActivity {
TextView name,city,phone;
Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        name=findViewById(R.id.name);
        city=findViewById(R.id.city);
        phone=findViewById(R.id.phone);
        logout=findViewById(R.id.logout);

        DatabaseReference reference= FirebaseDatabase.getInstance().getReference("User Details");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name1=snapshot.child("name").getValue().toString();
                String city1=snapshot.child("city").getValue().toString();
                String phone1=snapshot.child("phone").getValue().toString();

                name.setText(name1);
                city.setText(city1);
                phone.setText(phone1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Welcome.this, "Failed to get Data...", Toast.LENGTH_SHORT).show();
            }
        });

        logout.setOnClickListener(View->{
            startActivity(new Intent(Welcome.this,LogIn.class));
            FirebaseAuth.getInstance().signOut();
        });
    }
}