package com.example.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Date;

public class DateActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private Button okDate;
    private Button cancelDate;
    private TextView totalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        datePicker=findViewById(R.id.datePicker);
        okDate=findViewById(R.id.okdate);
        cancelDate=findViewById(R.id.cancelDate);
        totalPrice=findViewById(R.id.totalPrice);
        Bundle arg=getIntent().getExtras();
        if(arg!=null){
            String pr=arg.get(MainActivity.MESSAGE_PRICE).toString();
            totalPrice.setText(pr);
        }
        okDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String date=datePicker.getYear()+":"+datePicker.getMonth()+":"+datePicker.getDayOfMonth();
                Intent data=new Intent();
                data.putExtra(MainActivity.MESSAGE_DATE,date);
                setResult(RESULT_OK,data);
                finish();
            }
        });
        cancelDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}