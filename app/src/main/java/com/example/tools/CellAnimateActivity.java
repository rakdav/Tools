package com.example.tools;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class CellAnimateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cell_animate);
        ImageView img = (ImageView)findViewById(R.id.rabitAnim);
        // определим для ImageView какое-нибудь изображение
        img.setImageResource(R.drawable.multfilm);
        // создаем анимацию
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.losash_animation);
        // запуск анимации
        img.startAnimation(animation);
    }
}