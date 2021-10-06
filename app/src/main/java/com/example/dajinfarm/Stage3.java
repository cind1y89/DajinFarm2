package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Stage3 extends AppCompatActivity {

    Intent intent;
    ImageView imageView_chicken,imageView_peacock,imageView_ostrich,
              imageView_goat,imageView_camel,imageView_house,
              imageView_heart1,imageView_heart2,imageView_heart3,imageView_button;

    boolean[] animal={true,true,true,true,true};
    boolean[] animal_count={true,true,true,true,true};
    int wrong_count=0;

    int top,button,left,right;
    int time=500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage3);


        imageView_button=findViewById(R.id.imageView_home);
        imageView_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage3.this);
                alertDialog.setTitle(R.string.back);
                alertDialog.setMessage(R.string.back_dis)
                        .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                                pref.edit()
                                        .putBoolean("stage3",false)
                                        .putBoolean("stage3_chance",true)
                                        .apply();

                                intent=new Intent(Stage3.this,Map.class);
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


        imageView_chicken=findViewById(R.id.imageView_chicken);
        imageView_peacock=findViewById(R.id.imageView_peacock);
        imageView_ostrich=findViewById(R.id.imageView_ostrich);
        imageView_goat=findViewById(R.id.imageView_goat);
        imageView_camel=findViewById(R.id.imageView_camel);
        imageView_house=findViewById(R.id.imageView_house);

        imageView_heart1=findViewById(R.id.imageView_heart1);
        imageView_heart2=findViewById(R.id.imageView_heart2);
        imageView_heart3=findViewById(R.id.imageView_heart3);

        //right
        imageView_goat.setOnTouchListener(imgListener_right);
        imageView_ostrich.setOnTouchListener(imgListener_right);
        //wrong
        imageView_chicken.setOnTouchListener(imgListener_wrong);
        imageView_peacock.setOnTouchListener(imgListener_wrong);
        imageView_camel.setOnTouchListener(imgListener_wrong);


    }

    View.OnTouchListener imgListener_right=new View.OnTouchListener() {
        private float x, y;    // 原本圖片存在的X,Y軸位置
        private int mx, my; // 圖片被拖曳的X ,Y軸距離長度

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {          //判斷觸控的動作

                case MotionEvent.ACTION_DOWN:// 按下圖片時
                    x = event.getX();                  //觸控的X軸位置
                    y = event.getY();                  //觸控的Y軸位置

                case MotionEvent.ACTION_MOVE:// 移動圖片時

                    // getX()：是獲取當前控件(View)的座標
                    // getRawX()：是獲取相對顯示螢幕左上角的座標
                    // -300因為constraint layout
                    mx = (int) (event.getRawX() - x);
                    my = (int) (event.getRawY() - y - 300);
                    v.layout(mx, my, mx + v.getWidth(), my + v.getHeight());

                    if(left<=(mx + v.getWidth()) && (mx + v.getWidth())<=right){
                        if(top<=(my + v.getHeight()) && (my + v.getHeight())<=button){
                            v.setVisibility(View.INVISIBLE);
//                            Log.d("Test","恭喜，你找到正確動物了");
//                            Toast.makeText(Stage3.this,"恭喜，你找到正確動物了",(int)time).show();
                            checkImage();
                        }
                    }
                    break;
            }
            return true;
        }
    };

    View.OnTouchListener imgListener_wrong=new View.OnTouchListener() {
        private float x, y;    // 原本圖片存在的X,Y軸位置
        private int mx, my; // 圖片被拖曳的X ,Y軸距離長度

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {          //判斷觸控的動作

                case MotionEvent.ACTION_DOWN:// 按下圖片時
                    x = event.getX();                  //觸控的X軸位置
                    y = event.getY();                  //觸控的Y軸位置

                case MotionEvent.ACTION_MOVE:// 移動圖片時

                    // getX()：是獲取當前控件(View)的座標
                    // getRawX()：是獲取相對顯示螢幕左上角的座標
                    // -300因為constraint layout
                    mx = (int) (event.getRawX() - x);
                    my = (int) (event.getRawY() - y - 300);
                    v.layout(mx, my, mx + v.getWidth(), my + v.getHeight());

                    if(left<=(mx + v.getWidth()) && (mx + v.getWidth())<=right){
                        if(top<=(my + v.getHeight()) && (my + v.getHeight())<=button){
                            v.setVisibility(View.INVISIBLE);
//                            Log.d("Test","燈等，再注意看看");
//                            Toast.makeText(Stage3.this,"燈等，再注意看看",Toast.LENGTH_SHORT).show();
                            checkImage();
                        }
                    }
                    break;
            }

            return true;
        }
    };

    // check image status for ensuring ans
    private void checkImage() {
        if(imageView_chicken.getVisibility() == View.VISIBLE){
            animal[0]=true;
        }else if(imageView_chicken.getVisibility() == View.INVISIBLE && animal_count[0]){
            animal[0]=false; //image invisible
            animal_count[0]=false; //due for once only
            wrong_count++; //calculate for lives
            Toast.makeText(Stage3.this,"燈等，再注意看看",(int)time).show();
        }

        if(imageView_peacock.getVisibility() == View.VISIBLE){
            animal[1]=true;
        }else if(imageView_peacock.getVisibility() == View.INVISIBLE && animal_count[1]){
            animal[1]=false;
            animal_count[1]=false;
            wrong_count++;
            Toast.makeText(Stage3.this,"燈等，再注意看看",(int)time).show();
        }

        if(imageView_ostrich.getVisibility() == View.VISIBLE){
            animal[2]=true;
        }else if(imageView_ostrich.getVisibility() == View.INVISIBLE && animal_count[2]){
            animal[2]=false;
            animal_count[2]=false;
            Toast.makeText(Stage3.this,"恭喜，你找到正確動物了",(int)time).show();
        }

        if(imageView_goat.getVisibility() == View.VISIBLE){
            animal[3]=true;
        }else if(imageView_goat.getVisibility() == View.INVISIBLE && animal_count[3]){
            animal[3]=false;
            animal_count[3]=false;
            Toast.makeText(Stage3.this,"恭喜，你找到正確動物了",(int)time).show();
        }

        if(imageView_camel.getVisibility() == View.VISIBLE){
            animal[4]=true;
        }else if(imageView_camel.getVisibility() == View.INVISIBLE && animal_count[4]){
            animal[4]=false;
            animal_count[4]=false;
            wrong_count++;
            Toast.makeText(Stage3.this,"燈等，再注意看看",(int)time).show();
        }

        //lives UI
        if(wrong_count==1){
            imageView_heart1.setImageResource(R.drawable.heart2);
        }else if(wrong_count==2){
            imageView_heart2.setImageResource(R.drawable.heart2);
        }else if(wrong_count==3){
            imageView_heart3.setImageResource(R.drawable.heart2);
        }
        //final result
        if(!animal[2] &&!animal[3]){
            alertDialogCorrect();
        }
        if(!animal[0]&&!animal[1]&&!animal[4]){
            alertDialogFail();
        }

    }

    // wrong dialog
    private void alertDialogFail() {
        SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
        pref.edit()
                .putBoolean("stage3",false)
                .putBoolean("stage3_chance",true)
                .apply();

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage3.this);
        alertDialog.setTitle("");
        alertDialog.setMessage(R.string.ans_error)
                .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intent=new Intent(Stage3.this,Map.class);
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
                .putBoolean("stage3",true)
                .putBoolean("stage3_chance",true)
                .apply();

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage3.this);
        alertDialog.setTitle("");
        alertDialog.setMessage(R.string.ans_right)
                .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        intent=new Intent(Stage3.this,Map.class);
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
            top=imageView_house.getTop();
            button=imageView_house.getBottom();
            left=imageView_house.getLeft();
            right=imageView_house.getRight();

            Log.d("Test","getLeft "+imageView_house.getLeft());
            Log.d("Test","getRight "+imageView_house.getRight());
            Log.d("Test","getTop "+imageView_house.getTop());
            Log.d("Test","getBottom "+imageView_house.getBottom());
        }
    }
}