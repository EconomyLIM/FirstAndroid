package com.hallapractice1.programmingproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class TimerActivity extends AppCompatActivity {

    private Chronometer chronometer;
    private long PauseOffset = 0;
    private boolean isPlaying = false;
    private ToggleButton toggleButton;
    private Button reset_btn;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        toggleButton = (ToggleButton) findViewById(R.id.Toggle);
        reset_btn = (Button) findViewById(R.id.reset_btn);

        toggleButton.setText("Start");
        toggleButton.setTextOn("Pause");
        toggleButton.setTextOff(null);
        //토글 버튼의 이벤트리스너
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //b는 버튼의 상태로 눌렀을때 true 안눌렀을때 false가 된다.
                if(b){
                    chronometer.setBase(SystemClock.elapsedRealtime() - PauseOffset);
                    chronometer.start();
                    isPlaying = true;
                }else{
                    chronometer.stop();
                    PauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                    isPlaying = false;
                }
            }
        });

        reset_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isPlaying){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    PauseOffset = 0;
                    chronometer.start();
                    isPlaying = true;
                }
            }
        });

    }
}