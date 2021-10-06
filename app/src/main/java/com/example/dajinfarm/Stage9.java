package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import java.util.Random;

public class Stage9 extends AppCompatActivity {

    Button button;
    VideoView videoView;
    Intent intent;
    ImageView imageView_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage9);

        imageView_button=findViewById(R.id.imageView_home);
        imageView_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage9.this);
                alertDialog.setTitle(R.string.back);
                alertDialog.setMessage(R.string.back_dis)
                        .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                                pref.edit()
                                        .putBoolean("stage9",false)
                                        .putBoolean("stage9_chance",true)
                                        .apply();

                                intent=new Intent(Stage9.this,Map.class);
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


        button=findViewById(R.id.button);
        videoView=findViewById(R.id.videoView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random=new Random();
                int num =random.nextInt(2);
                Log.d("test","num"+num);
                if(num==0){
                    videoView.setVisibility(View.VISIBLE);
                    videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.succeed));
                    videoView.setMediaController(new MediaController(Stage9.this));
                    videoView.start();
                    result(0);
                }else{
                    videoView.setVisibility(View.VISIBLE);
                    videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.fail));
                    videoView.setMediaController(new MediaController(Stage9.this));
                    videoView.start();
                    result(1);
                }
                button.setOnClickListener(null);
            }
        });


    }

    private void result(int j) {
        if(j==0){
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                    pref.edit()
                            .putBoolean("stage9",true)
                            .putBoolean("stage9_chance",true)
                            .apply();

                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage9.this);
                    alertDialog.setTitle("");
                    alertDialog.setMessage(R.string.ans_right)
                            .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    intent=new Intent(Stage9.this,Map.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .setCancelable(false)
                            .show();
                }
            });
        }else{
            videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                    SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                    pref.edit()
                            .putBoolean("stage9",false)
                            .putBoolean("stage9_chance",true)
                            .apply();

                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage9.this);
                    alertDialog.setTitle("");
                    alertDialog.setMessage(R.string.ans_error)
                            .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    intent=new Intent(Stage9.this,Map.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .setCancelable(false)
                            .show();
                }
            });
        }
    }
}