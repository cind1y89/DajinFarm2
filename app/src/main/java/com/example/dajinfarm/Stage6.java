package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class Stage6 extends AppCompatActivity {

    Intent intent;
    int top1,top2,top3,
        button1,button2,button3,
        left1,left2,left3,
        right1,right2,right3;

    ImageView imageView_f1,imageView_f2,imageView_f3,
              imageView_f4,imageView_f5,imageView_f6,
              imageView_b1,imageView_b2,imageView_b3,
              imageView_heart1,imageView_heart2,imageView_heart3;

    boolean[] animal={true,true,true,true,true,true};
    boolean[] animal_count={true,true,true,true,true,true};
    int wrong_count=0;
    int time=500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage6);

        imageView_heart1=findViewById(R.id.imageView_heart1);
        imageView_heart2=findViewById(R.id.imageView_heart2);
        imageView_heart3=findViewById(R.id.imageView_heart3);

        imageView_b1=findViewById(R.id.imageView_basket1);
        imageView_b2=findViewById(R.id.imageView_basket2);
        imageView_b3=findViewById(R.id.imageView_basket3);

        imageView_f1=findViewById(R.id.imageView_fruit1);
        imageView_f2=findViewById(R.id.imageView_fruit2);
        imageView_f3=findViewById(R.id.imageView_fruit3);
        imageView_f4=findViewById(R.id.imageView_fruit4);
        imageView_f5=findViewById(R.id.imageView_fruit5);
        imageView_f6=findViewById(R.id.imageView_fruit6);

    }

    // wrong dialog
    private void alertDialogFail() {
        SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
        pref.edit()
                .putBoolean("stage6",false)
                .putBoolean("stage6_chance",true)
                .apply();

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage6.this);
        alertDialog.setTitle("");
        alertDialog.setMessage(R.string.ans_error)
                .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intent=new Intent(Stage6.this,Map.class);
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
                .putBoolean("stage6",true)
                .putBoolean("stage6_chance",true)
                .apply();

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage6.this);
        alertDialog.setTitle("");
        alertDialog.setMessage(R.string.ans_right)
                .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intent=new Intent(Stage6.this,Map.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if(hasFocus){
            top1=imageView_b1.getTop();
            button1=imageView_b1.getBottom();
            left1=imageView_b1.getLeft();
            right1=imageView_b1.getRight();

            top2=imageView_b2.getTop();
            button2=imageView_b2.getBottom();
            left2=imageView_b2.getLeft();
            right2=imageView_b2.getRight();

            top3=imageView_b3.getTop();
            button3=imageView_b3.getBottom();
            left3=imageView_b3.getLeft();
            right3=imageView_b3.getRight();


        }
    }
}