package com.example.dajinfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Title extends AppCompatActivity {

    ImageView imageView_IconRing,imageView_Icon;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);

        imageView_IconRing=findViewById(R.id.imageView_IconRing);
        imageView_Icon=findViewById(R.id.imageView_Icon);

        //2 secs imageView animation
        imageView_IconRing.startAnimation(AnimationUtils.loadAnimation(Title.this,R.anim.rotate));
        imageView_Icon.startAnimation(AnimationUtils.loadAnimation(Title.this,R.anim.alpha));

        //delay 2.3 secs for intent
        new Handler().postDelayed(() -> {
            intent=new Intent(Title.this,Main.class);
            startActivity(intent);
            finish();
        },2300);
    }
}