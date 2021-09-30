package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Stage_bouns extends AppCompatActivity {

    ImageView imageView_c1,imageView_c2;
    int count;
    boolean bonus1,bonus2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage_bouns);

        imageView_c1=findViewById(R.id.imageView_c1);
        imageView_c2=findViewById(R.id.imageView_c2);

        for(int i =0;i<=9;i++){
            String stage = "stage"+i;
            boolean status = getSharedPreferences("stage",MODE_PRIVATE).getBoolean(stage,false);
            if(status){
                count++;
            }
        }

        bonus1 = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("bonus1",false);
        bonus2 = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("bonus2",false);

        if(count==10 && !bonus2){
            imageView_c2.setImageResource(R.drawable.press2);
        }else if(count == 10){
            imageView_c2.setImageResource(R.drawable.press3);
        }

        if(count>=4 && count<=10 && !bonus1){
            imageView_c1.setImageResource(R.drawable.press2);
        }else if(count>=4 && count<=10){
            imageView_c1.setImageResource(R.drawable.press3);
        }

        imageView_c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count>=4 && count<=10 && !bonus1){
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage_bouns.this);
                    alertDialog.setTitle("注意");
                    alertDialog.setMessage("請出示給遊客中心服務員工並拿取兌換券")
                            .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    imageView_c1.setImageResource(R.drawable.press3);
                                    SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                                    pref.edit()
                                            .putBoolean("bonus1",true)
                                            .apply();
                                    imageView_c1.setOnClickListener(null);
                                }
                            })
                            .setNegativeButton("稍等一下", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setCancelable(false)
                            .show();

                }
            }
        });

        imageView_c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(count==10 && !bonus2){
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage_bouns.this);
                    alertDialog.setTitle("注意");
                    alertDialog.setMessage("請出示給遊客中心服務員工已拿取兌換券")
                            .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    imageView_c2.setImageResource(R.drawable.press3);
                                    SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                                    pref.edit()
                                            .putBoolean("bonus2",true)
                                            .apply();
                                    imageView_c2.setOnClickListener(null);
                                }
                            })
                            .setNegativeButton("稍等一下", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .setCancelable(false)
                            .show();

                }
            }
        });
    }


}