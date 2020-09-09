package com.example.gadsleaderboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this).load(R.drawable.gads)
                .into(imageView);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LandingActivity.this,MainActivity.class);
                startActivity(intent);
            }
        },1000);//equal 1 sec

    }

    public void moveToMain(View view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(LandingActivity.this,MainActivity.class);
                startActivity(intent);
            }
        },1000);//equal 1 sec
    }
}