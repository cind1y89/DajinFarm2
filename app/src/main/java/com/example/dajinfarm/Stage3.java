package com.example.dajinfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class Stage3 extends AppCompatActivity {

    ImageView imageView_chicken,imageView_peacock,imageView_ostrich,
              imageView_goat,imageView_camel,imageView_house;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage3);

        imageView_chicken=findViewById(R.id.imageView_chicken);
        imageView_peacock=findViewById(R.id.imageView_peacock);
        imageView_ostrich=findViewById(R.id.imageView_ostrich);
        imageView_goat=findViewById(R.id.imageView_goat);
        imageView_camel=findViewById(R.id.imageView_camel);
        imageView_house=findViewById(R.id.imageView_house);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if(hasFocus){
            Log.d("Test","getLeft "+imageView_house.getLeft());
            Log.d("Test","getRight "+imageView_house.getRight());
            Log.d("Test","getTop "+imageView_house.getTop());
            Log.d("Test","getBottom "+imageView_house.getBottom());
        }
    }
}