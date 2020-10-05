package com.example.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

public class TimeActivity extends AppCompatActivity {
    private TimePicker timePicker;
    private Button timeOk;
    private Button timeCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        timePicker=findViewById(R.id.timePicker);
        timeOk=findViewById(R.id.timeOk);
        timeCancel=findViewById(R.id.timeCancel);
        timeOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String time=timePicker.getHour()+":"+timePicker.getMinute();
                Intent data=new Intent();
                data.putExtra(MainActivity.MESSAGE_TIME,time);
                setResult(RESULT_OK,data);
                finish();
            }
        });
        timeCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}