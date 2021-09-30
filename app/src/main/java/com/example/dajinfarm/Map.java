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


    //GPS
    String[] title={
            "大鼻子的自由創作",
            "上旺土雞城","好蜜養蜂場","幸福20號農場",
            "進安宮","神隱村農場","松茂果園","寒溪吊橋",
            "劉記花生","春記麥芽酥","順進蜜餞行","百年茄苳樹"};

    String[] Dis={
            "大鼻子的自由創作提供各種木頭材質及各種機具讓小朋友發揮自己的創意製作任何作品，是一個兼具親子互動、學習木工創作與環保的好地方。",
            "標榜雞肉是現宰現烤的特色，現烤桶仔雞搭配當季在地野菜料理，鄉村風味好滋味。",
            "蜂場主人利用當地果園腐敗的水果給蜜蜂們補充營養，蜜的釀造到熟成約五到十天，因為是天然熟成的蜂蜜，堅持好的品質為顧客著想，努力的精神值得肯定。",
            "一座舊豬舍，一棵歲痕滄桑的老香楠樹，變形的紅磚和被遺棄的老石板，在一對青年回鄉創業的幸福故事裡，所有的一草一木、一磚一瓦，兩夫妻親手搭建出屬於他們在蘭陽平原上自己幸福的20號農場，請進到農場內找尋遊戲答案。",
            "1986年土地公廟改建，廟名改成進安宮，經擲筊獲土地公同意後，改供奉主神為天官、地官、水官，原供奉的土地公委身於偏殿，也因此留下「土地公賭輸，連廟也輸了」的傳說。",
            "神隱村坐落在寒溪的路上，地方環境優美，給都市人遠離塵囂及耳目一新的感受，農場內有親自下田拔菜動手做玉子燒的體驗，適合假日全家大小一同來認識各種植物蔬果。",
            "松茂果園春季有桑葚、桃子、紅肉李等，夏季有宜蘭紅心芭樂、珍珠芭樂、水晶芭樂及火龍果等，秋冬有文旦、福柑、帝王柑、金棗、柳丁、西施柚等柑橘水果。園主蔡松茂種植果樹逾50年，更不斷積極開發、改良及引進適合在地新品種水果，各種水果味美可口。",
            "寒溪吊橋位於大同鄉寒溪村，橋上彩繪台灣原住民的菱形圖騰，象徵著泰雅族中的祖靈之眼，是宜蘭縣最長、最美的鋼索吊橋。",
            "「劉記花生」傳承三代花生加工，堅持純手工低溫烘焙，嚴選無添加之頂級食材，重現傳承與堅持的懷念好滋味。九十九年獨創「三星蔥花生糖」風靡全台，已成為最具代表性的伴手禮之一，未來希望能將這份幸福感動的滋味傳遞至全世界。",
            "由劉春詳先生創辦，和太太郭秋美共同拜師學藝，以晶瑩剔透的麥芽糖鋪上細緻的花生粉和芝麻，在純手工細心揉製下，將大片原料逐一揉成長條狀，再用刀切成小塊，如此耗費心血才成這一塊塊香Q的麥芽酥，以獨家秘方處理麥芽糖，好吃不黏牙。",
            "順進蜜餞行是必去的宜蘭名產老店，店內提供李子類、梅子類、金棗類、橄欖類、梅片類、芒果類等多達90幾種的蜜餞，種類可說是應有盡有！",
            "宜蘭縣政府列管的珍貴老樹，樹齡約四、五百年，老樹、土地公廟是台灣農村常見的景觀，淋漓坑居民也在茄苳老樹下建了一間土地公廟，長久以来，老樹和土地公廟庇護著淋漓坑大大小小的居民，默默守護著這塊土地與居民的老樹有著許多村民共同的記憶與鄉居情懷。"
    };

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

        //stage intent
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
        imageView_s9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage9_chance",false);
                if (chance){
                    alertDialog();
                }else{
                    intent=new Intent(Map.this,Stage9.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
        imageView_sbouns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    intent=new Intent(Map.this,Stage_bouns.class);
                    startActivity(intent);
            }
        });

        //GPS



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