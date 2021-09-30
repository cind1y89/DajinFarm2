package com.example.dajinfarm;

import androidx.appcompat.app.AppCompatActivity;

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

public class Stage5_section2 extends AppCompatActivity {

    ImageView curView = null;
    TextView textView_time;
    private int countPair = 0;
    final int[] drawable = new int[]{
            R.drawable.card2,R.drawable.card4,
            R.drawable.card6,R.drawable.card8,
            R.drawable.card10};
    int[] pos = {3,1,3,4,2,4,0,1,0,2};
    int curent = -1;
    int count = 41;
    int a =0;
    Handler handler;
    int time=500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage5_section2);

        textView_time=findViewById(R.id.textView_time);
        handler=new Handler();
        handler.post(runnable);

        GridView gridView = findViewById(R.id.gridView);
        ImageAdpter2 imageAdpter = new ImageAdpter2(this);
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
                        ((ImageView) view).setImageResource(R.drawable.cardback2);
                    } else if (pos[curent] != pos[position]) {
                        curView.setImageResource(R.drawable.cardback2);
                        Toast.makeText(getApplicationContext(), "翻錯囉!!!", (int)time).show();
                    } else {
                        ((ImageView) view).setImageResource(drawable[pos[position]]);
                        countPair++;
                        Log.d("iouu",""+countPair);
                        if (countPair == 5) {
                            Toast.makeText(getApplicationContext(), "答對囉~", (int)time).show();
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
                    textView_time.setText("時間到!!!");

                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                    pref.edit()
                            .putBoolean("stage5_s2",false)
                            .putBoolean("stage5",false)
                            .putBoolean("stage5_chance",true)
                            .apply();

                    Intent intent = new Intent(Stage5_section2.this, Map.class);
                    startActivity(intent);
                    finish();

                }
            }   else
            {
                handler.removeCallbacks(runnable);
                textView_time.setText("恭喜你過關囉~");

                SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                pref.edit()
                        .putBoolean("stage5_s2",true)
                        .apply();
                boolean status = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage5_s1",false);
                if(status){
                    pref.edit()
                            .putBoolean("stage5",true)
                            .putBoolean("stage5_chance",true)
                            .apply();
                }else{
                    pref.edit()
                            .putBoolean("stage5",false)
                            .putBoolean("stage5_chance",true)
                            .apply();
                }

                Intent intent = new Intent(Stage5_section2.this, Map.class);
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