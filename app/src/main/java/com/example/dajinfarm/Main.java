package com.example.dajinfarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    Button button_start;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_start=findViewById(R.id.button_start);

        // intent
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(Main.this,Map.class);
                startActivity(intent);
                finish();
            }
        });
    }
}