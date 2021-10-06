package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Stage5 extends AppCompatActivity {

    Button button_start;
    Intent intent;
    ImageView imageView_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage5);

        imageView_button=findViewById(R.id.imageView_home);
        imageView_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage5.this);
                alertDialog.setTitle(R.string.back);
                alertDialog.setMessage(R.string.back_dis)
                        .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                                pref.edit()
                                        .putBoolean("stage5",false)
                                        .putBoolean("stage5_chance",true)
                                        .apply();

                                intent=new Intent(Stage5.this,Map.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });

        button_start=findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent=new Intent(Stage5.this,Stage5_section1.class);
                startActivity(intent);
                finish();
            }
        });
    }
}