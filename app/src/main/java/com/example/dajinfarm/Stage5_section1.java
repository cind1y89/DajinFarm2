package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Stage5_section1 extends AppCompatActivity {

    ImageView curView = null;
    ImageView imageView_button;
    Intent intent;
    TextView textView_time;
    private int countPair = 0;
    final int[] drawable = new int[]{
            R.drawable.card1,R.drawable.card3,
            R.drawable.card5,R.drawable.card7,
            R.drawable.card9};
    int[] pos = {0,1,3,2,2,4,0,1,3,4};
    int curent = -1;
    int count = 41;
    int a =0;
    Handler handler;
    int time=500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage5_section1);

        imageView_button=findViewById(R.id.imageView_home);
        imageView_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage5_section1.this);
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

                                intent=new Intent(Stage5_section1.this,Map.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("??????", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });

        textView_time=findViewById(R.id.textView_time);
        handler=new Handler();
        handler.post(runnable);

        GridView gridView = findViewById(R.id.gridView);
        ImageAdpter imageAdpter = new ImageAdpter(this);
        gridView.setAdapter(imageAdpter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (curent < 0) {
                    curent = position;
                    curView = (ImageView) view;
                    ((ImageView) view).setImageResource(drawable[pos[position]]);
                } else {
                    if (curent == position) {
                        ((ImageView) view).setImageResource(R.drawable.cardback1);
                    } else if (pos[curent] != pos[position]) {
                        curView.setImageResource(R.drawable.cardback1);
                        Toast.makeText(getApplicationContext(), "?????????!!!",(int)time).show();
                    } else {
                        ((ImageView) view).setImageResource(drawable[pos[position]]);
                        countPair++;
                        Log.d("iouu",""+countPair);
                        if (countPair == 5) {
                            Toast.makeText(getApplicationContext(), "?????????~",(int)time).show();
                        }
                        a = a+1;
                    }
                    curent = -1;
                }
            }
        });
    }

    final Runnable runnable = new Runnable() {
        public void run() {
            // TODO Auto-generated method stub
            if (a<5)
            {
                if (count > 0) {
                    textView_time.setText(Integer.toString(count - 1));
                    count--;
                    handler.postDelayed(runnable, 1000);
                } else {
                    textView_time.setText("?????????!!!");

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                    pref.edit()
                            .putBoolean("stage5_s1",false)
                            .apply();

                    Intent intent = new Intent(Stage5_section1.this, Stage5_section2.class);
                    startActivity(intent);
                    finish();

                }
            }   else
            {
                handler.removeCallbacks(runnable);
                textView_time.setText("??????????????????~");

                SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                pref.edit()
                        .putBoolean("stage5_s1",true)
                        .apply();

                Intent intent = new Intent(Stage5_section1.this, Stage5_section2.class);
                startActivity(intent);
                finish();
            }


        }
    };

    protected void onPause () {
        super.onPause();
        if (handler != null) {
            handler.removeCallbacks(runnable);
        }
    }
}