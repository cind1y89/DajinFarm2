package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

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

    boolean[] fruit={true,true,true,true,true,true};
    boolean[] fruit_count={true,true,true,true,true,true};
    int wrong_count=0,right_count=0,invisible_count=0;
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

        imageView_f1.setOnTouchListener(imgListener_spring);
        imageView_f2.setOnTouchListener(imgListener_spring);
        imageView_f3.setOnTouchListener(imgListener_summer);
        imageView_f4.setOnTouchListener(imgListener_summer);
        imageView_f5.setOnTouchListener(imgListener_winter);
        imageView_f6.setOnTouchListener(imgListener_winter);


    }

    View.OnTouchListener imgListener_spring=new View.OnTouchListener() {
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

                    if(left1<=(mx + v.getWidth()) && (mx + v.getWidth())<=right1){
                        if(top1<=(my + v.getHeight()) && (my + v.getHeight())<=button1){
                            v.setVisibility(View.INVISIBLE);
//                            Log.d("Test","恭喜，你找到正確動物了");
                            checkImageRight();
                        }
                    }
                    if(left2<=(mx + v.getWidth()) && (mx + v.getWidth())<=right2){
                        if(top2<=(my + v.getHeight()) && (my + v.getHeight())<=button2){
                            v.setVisibility(View.INVISIBLE);
                            checkImageWrong();
                        }
                    }
                    if(left3<=(mx + v.getWidth()) && (mx + v.getWidth())<=right3){
                        if(top3<=(my + v.getHeight()) && (my + v.getHeight())<=button3){
                            v.setVisibility(View.INVISIBLE);
                            checkImageWrong();
                        }
                    }
                    break;
            }
            return true;
        }
    };
    View.OnTouchListener imgListener_summer=new View.OnTouchListener() {
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

                    if(left1<=(mx + v.getWidth()) && (mx + v.getWidth())<=right1){
                        if(top1<=(my + v.getHeight()) && (my + v.getHeight())<=button1){
                            v.setVisibility(View.INVISIBLE);
//                            Log.d("Test","恭喜，你找到正確動物了");
                            checkImageWrong();
                        }
                    }
                    if(left2<=(mx + v.getWidth()) && (mx + v.getWidth())<=right2){
                        if(top2<=(my + v.getHeight()) && (my + v.getHeight())<=button2){
                            v.setVisibility(View.INVISIBLE);
                            checkImageRight();
                        }
                    }
                    if(left3<=(mx + v.getWidth()) && (mx + v.getWidth())<=right3){
                        if(top3<=(my + v.getHeight()) && (my + v.getHeight())<=button3){
                            v.setVisibility(View.INVISIBLE);
                            checkImageWrong();
                        }
                    }
                    break;
            }
            return true;
        }
    };
    View.OnTouchListener imgListener_winter=new View.OnTouchListener() {
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

                    if(left1<=(mx + v.getWidth()) && (mx + v.getWidth())<=right1){
                        if(top1<=(my + v.getHeight()) && (my + v.getHeight())<=button1){
                            v.setVisibility(View.INVISIBLE);
//                            Log.d("Test","恭喜，你找到正確動物了");
                            checkImageWrong();
                        }
                    }
                    if(left2<=(mx + v.getWidth()) && (mx + v.getWidth())<=right2){
                        if(top2<=(my + v.getHeight()) && (my + v.getHeight())<=button2){
                            v.setVisibility(View.INVISIBLE);
                            checkImageWrong();
                        }
                    }
                    if(left3<=(mx + v.getWidth()) && (mx + v.getWidth())<=right3){
                        if(top3<=(my + v.getHeight()) && (my + v.getHeight())<=button3){
                            v.setVisibility(View.INVISIBLE);
                            checkImageRight();
                        }
                    }
                    break;
            }
            return true;
        }
    };

    // check image status for ensuring ans
    private void checkImageWrong() {

        if(imageView_f1.getVisibility() == View.VISIBLE){
            fruit[0]=true;
        }else if(imageView_f1.getVisibility() == View.INVISIBLE && fruit_count[0]){
            fruit[0]=false; //image invisible
            fruit_count[0]=false; //due for once only
            wrong_count++; //calculate for lives
            invisible_count++;//for not all right ans
            Toast.makeText(Stage6.this,"燈等，不對喔",(int)time).show();
        }

        if(imageView_f2.getVisibility() == View.VISIBLE){
            fruit[1]=true;
        }else if(imageView_f2.getVisibility() == View.INVISIBLE && fruit_count[1]){
            fruit[1]=false; //image invisible
            fruit_count[1]=false; //due for once only
            wrong_count++; //calculate for lives
            invisible_count++;
            Toast.makeText(Stage6.this,"燈等，不對喔",(int)time).show();
        }


        if(imageView_f3.getVisibility() == View.VISIBLE){
            fruit[2]=true;
        }else if(imageView_f3.getVisibility() == View.INVISIBLE && fruit_count[2]){
            fruit[2]=false; //image invisible
            fruit_count[2]=false; //due for once only
            wrong_count++; //calculate for lives
            invisible_count++;
            Toast.makeText(Stage6.this,"燈等，不對喔",(int)time).show();
        }


        if(imageView_f4.getVisibility() == View.VISIBLE){
            fruit[3]=true;
        }else if(imageView_f4.getVisibility() == View.INVISIBLE && fruit_count[3]){
            fruit[3]=false; //image invisible
            fruit_count[3]=false; //due for once only
            wrong_count++; //calculate for lives
            invisible_count++;
            Toast.makeText(Stage6.this,"燈等，不對喔",(int)time).show();
        }


        if(imageView_f5.getVisibility() == View.VISIBLE){
            fruit[4]=true;
        }else if(imageView_f5.getVisibility() == View.INVISIBLE && fruit_count[4]){
            fruit[4]=false; //image invisible
            fruit_count[4]=false; //due for once only
            wrong_count++; //calculate for lives
            invisible_count++;
            Toast.makeText(Stage6.this,"燈等，不對喔",(int)time).show();
        }


        if(imageView_f6.getVisibility() == View.VISIBLE){
            fruit[5]=true;
        }else if(imageView_f6.getVisibility() == View.INVISIBLE && fruit_count[5]){
            fruit[5]=false; //image invisible
            fruit_count[5]=false; //due for once only
            wrong_count++; //calculate for lives
            invisible_count++;
            Toast.makeText(Stage6.this,"燈等，不對喔",(int)time).show();
        }

        //lives UI
        if(wrong_count==1){
            imageView_heart1.setImageResource(R.drawable.heart2);
        }else if(wrong_count==2){
            imageView_heart2.setImageResource(R.drawable.heart2);
        }else if(wrong_count==3){
            imageView_heart3.setImageResource(R.drawable.heart2);
            alertDialogFail();
        }

    }

    private void checkImageRight() {

        if(imageView_f1.getVisibility() == View.VISIBLE){
            fruit[0]=true;
        }else if(imageView_f1.getVisibility() == View.INVISIBLE && fruit_count[0]){
            fruit[0]=false; //image invisible
            fruit_count[0]=false; //due for once only
            right_count++;
            invisible_count++;
            Toast.makeText(Stage6.this,"沒錯，你答對了",(int)time).show();
        }

        if(imageView_f2.getVisibility() == View.VISIBLE){
            fruit[1]=true;
        }else if(imageView_f2.getVisibility() == View.INVISIBLE && fruit_count[1]){
            fruit[1]=false; //image invisible
            fruit_count[1]=false; //due for once only
            right_count++;
            invisible_count++;
            Toast.makeText(Stage6.this,"沒錯，你答對了",(int)time).show();
        }


        if(imageView_f3.getVisibility() == View.VISIBLE){
            fruit[2]=true;
        }else if(imageView_f3.getVisibility() == View.INVISIBLE && fruit_count[2]){
            fruit[2]=false; //image invisible
            fruit_count[2]=false; //due for once only
            right_count++;
            invisible_count++;
            Toast.makeText(Stage6.this,"沒錯，你答對了",(int)time).show();
        }


        if(imageView_f4.getVisibility() == View.VISIBLE){
            fruit[3]=true;
        }else if(imageView_f4.getVisibility() == View.INVISIBLE && fruit_count[3]){
            fruit[3]=false; //image invisible
            fruit_count[3]=false; //due for once only
            right_count++;
            invisible_count++;
            Toast.makeText(Stage6.this,"沒錯，你答對了",(int)time).show();
        }


        if(imageView_f5.getVisibility() == View.VISIBLE){
            fruit[4]=true;
        }else if(imageView_f5.getVisibility() == View.INVISIBLE && fruit_count[4]){
            fruit[4]=false; //image invisible
            fruit_count[4]=false; //due for once only
            right_count++;
            invisible_count++;
            Toast.makeText(Stage6.this,"沒錯，你答對了",(int)time).show();
        }


        if(imageView_f6.getVisibility() == View.VISIBLE){
            fruit[5]=true;
        }else if(imageView_f6.getVisibility() == View.INVISIBLE && fruit_count[5]){
            fruit[5]=false; //image invisible
            fruit_count[5]=false; //due for once only
            right_count++;
            invisible_count++;
            Toast.makeText(Stage6.this,"沒錯，你答對了",(int)time).show();
        }


        if(right_count==6){
            alertDialogCorrect();
        }else if(invisible_count==6){
            alertDialogFail(); //for wrong not util 3 times, but not all right
        }

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