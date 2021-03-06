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

public class Stage7 extends AppCompatActivity {

    Button button1,button2,button3,button4;
    Intent intent;
    ImageView imageView_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage7);

        imageView_button=findViewById(R.id.imageView_home);
        imageView_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage7.this);
                alertDialog.setTitle(R.string.back);
                alertDialog.setMessage(R.string.back_dis)
                        .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                                pref.edit()
                                        .putBoolean("stage7",false)
                                        .putBoolean("stage7_chance",true)
                                        .apply();

                                intent=new Intent(Stage7.this,Map.class);
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

        button1=findViewById(R.id.button_ans1);
        button2=findViewById(R.id.button_ans2);
        button3=findViewById(R.id.button_ans3);
        button4=findViewById(R.id.button_ans4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result(1);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result(0);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result(0);
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result(0);
            }
        });
    }

    private void result(int i) {
        if(i==0){
            SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
            pref.edit()
                    .putBoolean("stage7",false)
                    .putBoolean("stage7_chance",true)
                    .apply();

            AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage7.this);
            alertDialog.setTitle("");
            alertDialog.setMessage(R.string.ans_error)
                    .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            intent=new Intent(Stage7.this,Map.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .show();
        }else{
            SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
            pref.edit()
                    .putBoolean("stage7",true)
                    .putBoolean("stage7_chance",true)
                    .apply();

            AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage7.this);
            alertDialog.setTitle("");
            alertDialog.setMessage(R.string.ans_right)
                    .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            intent=new Intent(Stage7.this,Map.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .show();
        }


    }
}