package com.example.firebase_res_login;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {
EditText logEmail,logPass;
Button signIn1;
FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        logEmail=findViewById(R.id.logEmail);
        logPass=findViewById(R.id.logPass);
        signIn1=findViewById(R.id.logIn1);
        fAuth=FirebaseAuth.getInstance();

        signIn1.setOnClickListener(View->{
            String email=logEmail.getText().toString();
            String password=logPass.getText().toString();

            fAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                startActivity(new Intent(LogIn.this,Welcome.class));
                            } else {
                                Toast.makeText(LogIn.this, "Entered Password is Worng...",Toast.LENGTH_SHORT).show();
                                logPass.getText().clear();
                            }
                        }
                    });
        });
    }
}