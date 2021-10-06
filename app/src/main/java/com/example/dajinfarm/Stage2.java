package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class Stage2 extends AppCompatActivity {

    Intent intent;
    ImageView imageView_dice,imageView_map,
            imageView_heart1,imageView_heart2,imageView_heart3,imageView_button;
    int level=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2);


        imageView_button=findViewById(R.id.imageView_home);
        imageView_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage2.this);
                alertDialog.setTitle(R.string.back);
                alertDialog.setMessage(R.string.back_dis)
                        .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                                pref.edit()
                                        .putBoolean("stage2",false)
                                        .putBoolean("stage2_chance",true)
                                        .apply();

                                intent=new Intent(Stage2.this,Map.class);
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

        imageView_dice=findViewById(R.id.imageView_dice);
        imageView_map=findViewById(R.id.imageView_map);
        imageView_heart1=findViewById(R.id.imageView_heart1);
        imageView_heart2=findViewById(R.id.imageView_heart2);
        imageView_heart3=findViewById(R.id.imageView_heart3);

        RotateAnimation rotateAnimation1 = new RotateAnimation
                (0f,60f,RotateAnimation.RELATIVE_TO_SELF,
                        0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation rotateAnimation2 = new RotateAnimation
                (60f,120f,RotateAnimation.RELATIVE_TO_SELF,
                        0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation rotateAnimation3 = new RotateAnimation
                (120f,180f,RotateAnimation.RELATIVE_TO_SELF,
                        0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation rotateAnimation4 = new RotateAnimation
                (180f,240f,RotateAnimation.RELATIVE_TO_SELF,
                        0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation rotateAnimation5 = new RotateAnimation
                (240f,300f,RotateAnimation.RELATIVE_TO_SELF,
                        0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation rotateAnimation6 = new RotateAnimation
                (300f,360f,RotateAnimation.RELATIVE_TO_SELF,
                        0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);


        rotateAnimation1.setDuration(200);
        rotateAnimation1.setFillAfter(true);
        rotateAnimation2.setDuration(200);
        rotateAnimation2.setFillAfter(true);
        rotateAnimation3.setDuration(200);
        rotateAnimation3.setFillAfter(true);
        rotateAnimation4.setDuration(200);
        rotateAnimation4.setFillAfter(true);
        rotateAnimation5.setDuration(200);
        rotateAnimation5.setFillAfter(true);
        rotateAnimation6.setDuration(200);
        rotateAnimation6.setFillAfter(true);

        imageView_dice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wrong = getSharedPreferences("stage",MODE_PRIVATE).getInt("stage2_wrong",0);
                int right = getSharedPreferences("stage",MODE_PRIVATE).getInt("stage2_right",0);
                if(wrong==1){
                    imageView_heart1.setImageResource(R.drawable.heart2);
                }else if(wrong==2){
                    imageView_heart2.setImageResource(R.drawable.heart2);
                }else if(wrong==3){
                    imageView_heart3.setImageResource(R.drawable.heart2);
                    alertDialogFail();
                }
                if(right==3){
                    alertDialogCorrect();
                }


                imageView_dice.setImageResource(R.drawable.d6);
                imageView_dice.startAnimation(rotateAnimation1);
                new Handler().postDelayed(() -> {
                    imageView_dice.setImageResource(R.drawable.d5);
                    imageView_dice.startAnimation(rotateAnimation2);
                },200);
                new Handler().postDelayed(() -> {
                    imageView_dice.setImageResource(R.drawable.d4);
                    imageView_dice.startAnimation(rotateAnimation3);
                },400);
                new Handler().postDelayed(() -> {
                    imageView_dice.setImageResource(R.drawable.d3);
                    imageView_dice.startAnimation(rotateAnimation4);
                },600);
                new Handler().postDelayed(() -> {
                    imageView_dice.setImageResource(R.drawable.d2);
                    imageView_dice.startAnimation(rotateAnimation5);
                },800);
                new Handler().postDelayed(() -> {
                    imageView_dice.setImageResource(R.drawable.d1);
                    imageView_dice.startAnimation(rotateAnimation6);
                },1000);

                new Handler().postDelayed(() -> {
                    Random random=new Random();
                    int num =random.nextInt(6);
                    if(num==6){
                        imageView_dice.setImageResource(R.drawable.d6);
                    }else if(num==5){
                        imageView_dice.setImageResource(R.drawable.d5);
                    }else if(num==4){
                        imageView_dice.setImageResource(R.drawable.d4);
                    }else if(num==3){
                        imageView_dice.setImageResource(R.drawable.d3);
                    }else if(num==2){
                        imageView_dice.setImageResource(R.drawable.d2);
                    }else if(num==1){
                        imageView_dice.setImageResource(R.drawable.d1);
                    }else if(num==0){
                        imageView_dice.setImageResource(R.drawable.d1);
                        num=1;
                    }

                    level+=num;

                    if(level==0 || level>15){
                        imageView_map.setImageResource(R.drawable.bee0);
                        level=0;
                    }else if(level==1){
                        imageView_map.setImageResource(R.drawable.bee1);
                        intent = new Intent(Stage2.this, Stage2_question.class);
                        intent.putExtra("index", 0);
                        startActivity(intent);
                    }else if(level==2){
                        imageView_map.setImageResource(R.drawable.bee2);
                    }else if(level==3){
                        imageView_map.setImageResource(R.drawable.bee3);
                        intent = new Intent(Stage2.this, Stage2_question.class);
                        intent.putExtra("index", 2);
                        startActivity(intent);
                    }else if(level==4){
                        imageView_map.setImageResource(R.drawable.bee4);
                    }else if(level==5){
                        imageView_map.setImageResource(R.drawable.bee5);
                        intent = new Intent(Stage2.this, Stage2_question.class);
                        intent.putExtra("index", 4);
                        startActivity(intent);
                    }else if(level==6){
                        imageView_map.setImageResource(R.drawable.bee6);
                        intent = new Intent(Stage2.this, Stage2_question.class);
                        intent.putExtra("index", 5);
                        startActivity(intent);
                    }else if(level==7){
                        imageView_map.setImageResource(R.drawable.bee7);
                    }else if(level==8){
                        imageView_map.setImageResource(R.drawable.bee8);
                    }else if(level==9){
                        imageView_map.setImageResource(R.drawable.bee9);
                        intent = new Intent(Stage2.this, Stage2_question.class);
                        intent.putExtra("index", 8);
                        startActivity(intent);
                    }else if(level==10){
                        imageView_map.setImageResource(R.drawable.bee10);
                        intent = new Intent(Stage2.this, Stage2_question.class);
                        intent.putExtra("index", 9);
                        startActivity(intent);
                    }else if(level==11){
                        imageView_map.setImageResource(R.drawable.bee11);
                    }else if(level==12){
                        imageView_map.setImageResource(R.drawable.bee12);
                        intent = new Intent(Stage2.this, Stage2_question.class);
                        intent.putExtra("index", 11);
                        startActivity(intent);
                    }else if(level==13){
                        imageView_map.setImageResource(R.drawable.bee13);
                    }else if(level==14){
                        imageView_map.setImageResource(R.drawable.bee14);
                        intent = new Intent(Stage2.this, Stage2_question.class);
                        intent.putExtra("index", 13);
                        startActivity(intent);
                    }else if(level==15){
                        imageView_map.setImageResource(R.drawable.bee15);
                        intent = new Intent(Stage2.this, Stage2_question.class);
                        intent.putExtra("index", 14);
                        startActivity(intent);
                    }
                },1200);
            }
        });
    }

    // wrong dialog
    private void alertDialogFail() {
        SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
        pref.edit()
                .putBoolean("stage2",false)
                .putBoolean("stage2_chance",true)
                .apply();

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage2.this);
        alertDialog.setTitle("");
        alertDialog.setMessage(R.string.ans_error)
                .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intent=new Intent(Stage2.this,Map.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }
    // right dialog
    private void alertDialogCorrect() {
        SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
        pref.edit()
                .putBoolean("stage2",true)
                .putBoolean("stage2_chance",true)
                .apply();

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage2.this);
        alertDialog.setTitle("");
        alertDialog.setMessage(R.string.ans_right)
                .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intent=new Intent(Stage2.this,Map.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }
}