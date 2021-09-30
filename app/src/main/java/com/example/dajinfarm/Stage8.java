package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Stage8 extends AppCompatActivity {

    EditText t1,t2,t3;
    String text1,text2,text3;
    Button button;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage8);

        t1=findViewById(R.id.ans1);
        t2=findViewById(R.id.ans2);
        t3=findViewById(R.id.ans3);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text1= String.valueOf(t1.getText());
                text2= String.valueOf(t2.getText());
                text3= String.valueOf(t3.getText());
                if(text1.equals("麥芽酥") &&text2.equals("花生糖")&&text3.equals("蜜餞")){
                    SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                    pref.edit()
                            .putBoolean("stage8",true)
                            .putBoolean("stage8_chance",true)
                            .apply();

                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage8.this);
                    alertDialog.setTitle("");
                    alertDialog.setMessage(R.string.ans_right)
                            .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    intent=new Intent(Stage8.this,Map.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .setCancelable(false)
                            .show();
                }
                else{
                    SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                    pref.edit()
                            .putBoolean("stage8",false)
                            .putBoolean("stage8_chance",true)
                            .apply();

                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage8.this);
                    alertDialog.setTitle("");
                    alertDialog.setMessage(R.string.ans_error)
                            .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    intent=new Intent(Stage8.this,Map.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .setCancelable(false)
                            .show();
                }
            }
        });

    }
}