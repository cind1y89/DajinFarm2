package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    Button button_start;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_start=findViewById(R.id.button_start);
        //檢測權限
       if(ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
          ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            // intent
            button_start.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    intent=new Intent(Main.this,Map.class);
                    startActivity(intent);
                    finish();
                }
            });
        }else{
           //通知開啟權限
           ActivityCompat.requestPermissions(Main.this,
                   new String[] {
                           Manifest.permission.ACCESS_FINE_LOCATION,
                           Manifest.permission.ACCESS_COARSE_LOCATION}, 1
                   );
           // intent
           button_start.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   intent=new Intent(Main.this,Map.class);
                   startActivity(intent);
                   finish();
               }
           });
       }
    }


}