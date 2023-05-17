package com.hallapractice1.programmingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    private TextView tv_result;
    private ImageView iv_result;

    com.google.android.material.card.MaterialCardView cardview1,cardview2,cardview3,cardview4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String nickName = intent.getStringExtra("nickName"); //닉네임 전달받음
        String photoURL = intent.getStringExtra("photourl"); // 프로필 사진 url 전달받음

        tv_result = findViewById(R.id.tv_result1);
        tv_result.setText(nickName);

        iv_result = findViewById(R.id.iv_result1);
        Glide.with(this).load(photoURL).into(iv_result);


        cardview1 = (com.google.android.material.card.MaterialCardView)findViewById(R.id.dash1);

        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intent);
            }
        });

        cardview2 = (com.google.android.material.card.MaterialCardView)findViewById(R.id.dash2);
        cardview3 = (com.google.android.material.card.MaterialCardView)findViewById(R.id.dash3);
        cardview4 = (com.google.android.material.card.MaterialCardView)findViewById(R.id.dash4);

        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
                startActivity(intent);
            }
        });

        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TodoActivity.class);
                startActivity(intent);
            }
        });

        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TimerActivity.class);
                startActivity(intent);
            }
        });
    }
}