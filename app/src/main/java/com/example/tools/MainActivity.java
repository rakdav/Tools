package com.example.tools;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private TextView resDate;
    private EditText input;
    private SeekBar progressBar;
    private TextView price;
    private TextView add;
    private TextView total;
    private int currentProgress;
    private double Price;
    private ImageButton buttonDate;
    private ImageButton buttonTime;
    private static final int REQUEST_DATE=1;
    public static final String MESSAGE_DATE="Date";
    private static final int REQUEST_TIME=2;
    public static final String MESSAGE_TIME="Time";
    public static final String  MESSAGE_PRICE="Total";
    private String resD,resTime;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=findViewById(R.id.input);
        price=findViewById(R.id.price);
        add=findViewById(R.id.add);
        total=findViewById(R.id.total);
        progressBar=findViewById(R.id.seek);
        buttonDate=findViewById(R.id.date);
        buttonTime=findViewById(R.id.time);
        resDate=findViewById(R.id.resDate);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Price=Double.parseDouble(charSequence.toString());
                currentProgress=progressBar.getProgress();
                GetCalculate();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        progressBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Price=Double.parseDouble(input.getText().toString());
                currentProgress=i;
                GetCalculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//        buttonDate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,DateActivity.class);
////                startActivity(intent);
//                intent.putExtra(MESSAGE_PRICE,total.getText().toString());
//                startActivityForResult(intent,REQUEST_DATE);
//            }
//        });
//        buttonTime.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(MainActivity.this,TimeActivity.class);
//                intent.putExtra(MESSAGE_PRICE,total.getText().toString());
//                startActivityForResult(intent,REQUEST_TIME);
//            }
//        });
    }
    private void GetCalculate()
    {
        price.setText(Double.toString(Price)+" руб.");
        double tea=Price*currentProgress/100;
        add.setText(Double.toString(tea)+" руб.");
        double totalSum=Price+tea;
        total.setText(Double.toString(totalSum)+" руб.");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==REQUEST_DATE){
            if(resultCode==RESULT_OK){
                resD=data.getStringExtra(MESSAGE_DATE);
            }
            else {
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
            }
        }
        else
        if(requestCode==REQUEST_TIME){
            if(resultCode==RESULT_OK){
                resTime=data.getStringExtra(MESSAGE_TIME);
            }
            else {
                Toast.makeText(this, "Error", Toast.LENGTH_LONG).show();
            }
        }
        resDate.setText(resD+" "+resTime);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent;
         switch (item.getItemId())
         {
             case R.id.date:
                 intent=new Intent(MainActivity.this,DateActivity.class);
                 intent.putExtra(MESSAGE_PRICE,total.getText().toString());
                 startActivityForResult(intent,REQUEST_DATE);
                 return true;
             case R.id.time:
                 intent=new Intent(MainActivity.this,TimeActivity.class);
                 intent.putExtra(MESSAGE_PRICE,total.getText().toString());
                 startActivityForResult(intent,REQUEST_TIME);
                 return true;
             case R.id.drawLine:
                 intent=new Intent(MainActivity.this,DrawActivity.class);
                 startActivity(intent);
         }
        return super.onOptionsItemSelected(item);
    }
}