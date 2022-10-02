package com.example.photo_editing;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import com.github.dhaval2404.imagepicker.ImagePicker;

public class MainActivity extends AppCompatActivity {
public static Uri imgUri;
ImageView imageView;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView=findViewById(R.id.imageView);
        button=findViewById(R.id.button);
        imageView.setOnClickListener(View->{
            ImagePicker.Companion.with(this)
                    .crop()
                    .start();
        });
        button.setOnClickListener(View->{
            ImagePicker.Companion.with(this)
                    .crop()
                    .start();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try{
            imgUri=data.getData();
            if(!imgUri.equals(""))
            startActivity(new Intent(MainActivity.this,FinalActivity.class));
        }
        catch (Exception ex){

        }
    }
}