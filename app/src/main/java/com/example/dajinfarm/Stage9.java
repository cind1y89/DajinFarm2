package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class Stage9 extends AppCompatActivity {

    Button button;
    VideoView videoView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage9);

        button=findViewById(R.id.button);
        videoView=findViewById(R.id.videoView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                videoView.setVisibility(View.VISIBLE);
                videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.pray2));
                videoView.setMediaController(new MediaController(Stage9.this));
                videoView.start();
            }
        });

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
    }
}