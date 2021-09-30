package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Map extends AppCompatActivity {

    // Press twice for leaving
    long waitTime = 2000;
    long touchTime = 0;

    // UI
    ImageView imageView_s0,imageView_s1,imageView_s2,imageView_s3,imageView_s4,
              imageView_s5,imageView_s6,imageView_s7,imageView_s8,imageView_s9,
              imageView_sbouns,imageView_stagepic,imageView_coupon;
    TextView textView_title,textView_titleDis;
    Button button_start,button_restart;
    Intent intent;

    // Storage
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        imageView_coupon=findViewById(R.id.imageView_cupon);
        imageView_s0=findViewById(R.id.imageView_s0);
        imageView_s1=findViewById(R.id.imageView_s1);
        imageView_s2=findViewById(R.id.imageView_s2);
        imageView_s3=findViewById(R.id.imageView_s3);
        imageView_s4=findViewById(R.id.imageView_s4);
        imageView_s5=findViewById(R.id.imageView_s5);
        imageView_s6=findViewById(R.id.imageView_s6);
        imageView_s7=findViewById(R.id.imageView_s7);
        imageView_s8=findViewById(R.id.imageView_s8);
        imageView_s9=findViewById(R.id.imageView_s9);
        imageView_sbouns=findViewById(R.id.imageView_sbonus);
        textView_title=findViewById(R.id.textView_tilte);
        imageView_stagepic=findViewById(R.id.imageView_stagepic);
        textView_titleDis=findViewById(R.id.textView_discription);
        button_start=findViewById(R.id.button_start);
        button_restart=findViewById(R.id.button_restart);

        // clear all value
        button_restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                pref.edit()
                        .clear()
                        .apply();
                intent=new Intent(Map.this,Map.class);
                startActivity(intent);
                finish();
            }
        });

        //read storage
        for(int i =0;i<=9;i++){
            String stage = "stage"+i;
            boolean status = getSharedPreferences("stage",MODE_PRIVATE).getBoolean(stage,false);
            if(status & i==0){
                imageView_s0.setImageResource(R.drawable.stamp1);
            }else if(status & i==1){
                imageView_s1.setImageResource(R.drawable.stamp2);
            }else if(status & i==2){
                imageView_s2.setImageResource(R.drawable.stamp3);
            }else if(status & i==3){
                imageView_s3.setImageResource(R.drawable.stamp4);
            }else if(status & i==4){
                imageView_s4.setImageResource(R.drawable.stamp5);
            }else if(status & i==5){
                imageView_s5.setImageResource(R.drawable.stamp6);
            }else if(status & i==6){
                imageView_s6.setImageResource(R.drawable.stamp7);
            }else if(status & i==7){
                imageView_s7.setImageResource(R.drawable.stamp8);
            }else if(status & i==8){
                imageView_s8.setImageResource(R.drawable.stamp9);
            }else if(status & i==9){
                imageView_s9.setImageResource(R.drawable.stamp10);
            }
        }

        imageView_s0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage0_chance",false);
                if (chance){
                    alertDialog();
                }else{
                    intent=new Intent(Map.this,Stage0.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        imageView_s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage1_chance",false);
                if (chance){
                    alertDialog();
                }else{
                    intent=new Intent(Map.this,Stage1.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        imageView_s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage2_chance",false);
                if (chance){
                    alertDialog();
                }else{
                    intent=new Intent(Map.this,Stage2.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        imageView_s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage3_chance",false);
                if (chance){
                    alertDialog();
                }else{
                    intent=new Intent(Map.this,Stage3.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        imageView_s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage4_chance",false);
                if (chance){
                    alertDialog();
                }else{
                    intent=new Intent(Map.this,Stage4.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        imageView_s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage5_chance",false);
                if (chance){
                    alertDialog();
                }else{
                    intent=new Intent(Map.this,Stage5.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        imageView_s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage6_chance",false);
                if (chance){
                    alertDialog();
                }else{
                    intent=new Intent(Map.this,Stage6.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        imageView_s7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage7_chance",false);
                if (chance){
                    alertDialog();
                }else{
                    intent=new Intent(Map.this,Stage7.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        imageView_s8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage8_chance",false);
                if (chance){
                    alertDialog();
                }else{
                    intent=new Intent(Map.this,Stage8.class);
                    startActivity(intent);
                    finish();
                }

            }
        });


    }

    // chance finish
    private void alertDialog() {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Map.this);
        alertDialog.setTitle("");
        alertDialog.setMessage(R.string.stage_dis)
                .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setCancelable(false)
                .show();
    }

    // Press twice for leaving
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(event.getAction() == KeyEvent.ACTION_DOWN && KeyEvent.KEYCODE_BACK == keyCode) {
            long currentTime = System.currentTimeMillis();
            if((currentTime-touchTime)>=waitTime) {
                //讓Toast的顯示時間和等待時間相同
                Toast.makeText(this, "再按一次退出", (int)waitTime).show();
                touchTime = currentTime;
            }else {
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}