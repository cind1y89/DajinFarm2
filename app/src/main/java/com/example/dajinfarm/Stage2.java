package com.example.dajinfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Stage2 extends AppCompatActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2);

        intent = new Intent(Stage2.this, Stage2_question.class);
        intent.putExtra("index", 0);
        startActivity(intent);
    }
}