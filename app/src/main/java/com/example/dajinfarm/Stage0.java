package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Stage0 extends AppCompatActivity {

    Button button1,button2,button3;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage0);
        button1=findViewById(R.id.button_ans1);
        button2=findViewById(R.id.button_ans2);
        button3=findViewById(R.id.button_ans3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result(0);
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
                result(1);
            }
        });

    }

    private void result(int i) {
        if(i==0){
            SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
            pref.edit()
                    .putBoolean("stage0",false)
                    .putBoolean("stage0_chance",true)
                    .apply();

            AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage0.this);
            alertDialog.setTitle("");
            alertDialog.setMessage(R.string.ans_error)
                    .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            intent=new Intent(Stage0.this,Map.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .show();
        }else{
            SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
            pref.edit()
                    .putBoolean("stage0",true)
                    .putBoolean("stage0_chance",true)
                    .apply();

            AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage0.this);
            alertDialog.setTitle("");
            alertDialog.setMessage(R.string.ans_right)
                    .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            intent=new Intent(Stage0.this,Map.class);
                            startActivity(intent);
                            finish();
                        }
                    })
                    .setCancelable(false)
                    .show();
        }


    }

}