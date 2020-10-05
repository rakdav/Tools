package com.example.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private EditText input;
    private SeekBar progressBar;
    private TextView price;
    private TextView add;
    private TextView total;
    private int currentProgress;
    private double Price;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=findViewById(R.id.input);
        price=findViewById(R.id.price);
        add=findViewById(R.id.add);
        total=findViewById(R.id.total);
        progressBar=findViewById(R.id.seek);
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
    }
    private void GetCalculate()
    {
        price.setText(Double.toString(Price)+" руб.");
        double tea=Price*currentProgress/100;
        add.setText(Double.toString(tea)+" руб.");
        double totalSum=Price+tea;
        total.setText(Double.toString(totalSum)+" руб.");
    }
}