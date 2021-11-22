package com.example.dajinfarm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.Manifest.permission.ACCESS_FINE_LOCATION;


public class Map extends AppCompatActivity {

    // Press twice for leaving
    long waitTime = 2000;
    long touchTime = 0;

    // UI
    ImageView imageView_s0, imageView_s1, imageView_s2, imageView_s3, imageView_s4,
            imageView_s5, imageView_s6, imageView_s7, imageView_s8, imageView_s9,
            imageView_sbouns, imageView_stagepic;
    TextView textView_title, textView_titleDis;
    Button button_start, button_restart,button_reGPS;
    Intent intent;


    //GPS
    TextView textView_gpsX, textView_gpsY;
    private double locationX = 0.0;
    private double locationY = 0.0;
    boolean gpsON = false;
    LocationManager locationManager;


    String[] title = {
            "大鼻子的自由創作",
            "上旺土雞城", "好蜜養蜂場", "幸福20號農場",
            "進安宮", "神隱村農場", "松茂果園", "寒溪吊橋",
            "劉記花生", "春記麥芽酥", "順進蜜餞行", "百年茄苳樹"};

    String[] titleDis = {
            "大鼻子的自由創作提供各種木頭材質及各種機具讓小朋友發揮自己的創意製作任何作品，是一個兼具親子互動、學習木工創作與環保的好地方。",
            "標榜雞肉是現宰現烤的特色，現烤桶仔雞搭配當季在地野菜料理，鄉村風味好滋味。",
            "蜂場主人利用當地果園腐敗的水果給蜜蜂們補充營養，蜜的釀造到熟成約五到十天，因為是天然熟成的蜂蜜，堅持好的品質為顧客著想，努力的精神值得肯定。",
            "一座舊豬舍，一棵歲痕滄桑的老香楠樹，變形的紅磚和被遺棄的老石板，一對青年回鄉創業的故事，兩夫妻親手搭建出屬於他們的幸福20號農場，請到農場內找尋答案。",
            "1986年土地公廟改建廟名改成進安宮，經擲筊獲土地公同意後，改供奉主神為天官、地官、水官，原供奉的土地公委身於偏殿，留下「土地公賭輸，連廟也輸了」的傳說。",
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

        //GPS
        textView_gpsX=findViewById(R.id.textView_gpsX);
        textView_gpsY=findViewById(R.id.textView_gpsY);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);//位置解析的精度,高或低 引數: Criteria. ACCURACY_FINE,精確模式; Criteria. ACCURACY_COARSE,模糊模式;
        criteria.setAltitudeRequired(false);//是否提供海拔高度資訊,是或否
        criteria.setBearingRequired(false);//是否提供方向資訊,是或否
        criteria.setCostAllowed(false);//是否允許運營商計費,是或否
        criteria.setPowerRequirement(Criteria.POWER_LOW);//電池消耗,無、低、中、高
        String provider = locationManager.getBestProvider(criteria, false);
        //詢問是否存取位置資訊
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(Map.this,"請開啟定位權限",Toast.LENGTH_LONG).show();
            finish();
        }else{
            Location location = locationManager.getLastKnownLocation(provider);
            updateLocation(location);
            locationManager.requestLocationUpdates(provider, 3000, 0, locationListener);
            if(location==null){
                Toast.makeText(Map.this,"請開啟GPS與網路再重新啟動系統",Toast.LENGTH_LONG).show();
            }
        }




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
        button_start=findViewById(R.id.button);
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
                    setDis(0);
                    alertDialog();
                }else{
                    setDis(0);
                    button_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent=new Intent(Map.this,Stage0.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }

            }
        });
        imageView_s1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage1_chance",false);
                if (chance){
                    setDis(1);
                    alertDialog();
                }else{
                    setDis(1);
                    button_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent=new Intent(Map.this,Stage1.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }

            }
        });
        imageView_s2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage2_chance",false);
                if (chance){
                    setDis(2);
                    alertDialog();
                }else{
                    setDis(2);
                    button_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent=new Intent(Map.this,Stage2.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }

            }
        });
        imageView_s3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage3_chance",false);
                if (chance){
                    setDis(3);
                    alertDialog();
                }else{
                    setDis(3);
                    button_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent=new Intent(Map.this,Stage3.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }
            }
        });
        imageView_s4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage4_chance",false);
                if (chance){
                    setDis(4);
                    alertDialog();
                }else{
                    setDis(4);
                    button_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent=new Intent(Map.this,Stage4.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }

            }
        });
        imageView_s5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage5_chance",false);
                if (chance){
                    setDis(5);
                    alertDialog();
                }else{
                    setDis(5);
                    button_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent=new Intent(Map.this,Stage5.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }

            }
        });
        imageView_s6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage6_chance",false);
                if (chance){
                    setDis(6);
                    alertDialog();
                }else{
                    setDis(6);
                    button_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent=new Intent(Map.this,Stage6.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }

            }
        });
        imageView_s7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage7_chance",false);
                if (chance){
                    setDis(7);
                    alertDialog();
                }else{
                    setDis(7);
                    button_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent=new Intent(Map.this,Stage7.class);
                            startActivity(intent);
                            finish();
                        }
                    });
                }

            }
        });
        imageView_s8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage8_chance",false);
                if (chance){
                    setDis(8);
                    alertDialog();
                }else{
                    setDis(8);
                    button_start.setText("下一頁");
                    button_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            setDis(9);
                            button_start.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    button_start.setText(R.string.stage_button);
                                    setDis(10);
                                    button_start.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View view) {
                                            intent=new Intent(Map.this,Stage8.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    });
                                }
                            });
                        }
                    });
                }
            }
        });
        imageView_s9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage9_chance",false);
                if (chance){
                    setDis(11);
                    alertDialog();
                }else{
                    setDis(11);
                    button_start.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            intent=new Intent(Map.this,Stage9.class);
                            startActivity(intent);
                            finish();
                        }
                    });
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

        //gps intent
        GPS();
        //gps intent for redo gps through button
        button_reGPS=findViewById(R.id.button_reGPS);
        button_reGPS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPS();
            }
        });

    }

    private void GPS() {
        button_start.setText(R.string.GPS_wrong);
        Log.d("Test","X"+locationX);
        Log.d("Test","Y"+locationY);
        //gps intent

        //大鼻子 (?,?)

        //上旺土雞城	(24.6346 653,121.7204 62)
        if(locationX>24.6343 && locationX<24.6349 && locationY>121.7201 && locationY<121.7207){
            boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage1_chance",false);
            if (chance){
                setDis(1);
                alertDialog();
                button_start.setText(R.string.stage_dis);
            }else{
                setDis(1);
                button_start.setText(R.string.start1);
                button_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent=new Intent(Map.this,Stage1.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
        //好蜜養蜂場 (24.6370 542,121.7159 267)
        else if(locationX>24.6370242&& locationX<24.6370642 && locationY>121.7159556  && locationY<121.7159963 ){
            boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage2_chance",false);
            if (chance){
                setDis(2);
                alertDialog();
                button_start.setText(R.string.stage_dis);
            }else{
                setDis(2);
                button_start.setText(R.string.start1);
                button_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent=new Intent(Map.this,Stage2.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
        //幸福20號農場	(24.6336321,121.7124447)
        else if(locationX>24.6336203 && locationX<24.6337803 && locationY>121.7123916 && locationY<121.7124316){
            boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage3_chance",false);
            if (chance){
                setDis(3);
                alertDialog();
                button_start.setText(R.string.stage_dis);
            }else{
                setDis(3);
                button_start.setText(R.string.start1);
                button_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent=new Intent(Map.this,Stage3.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
        //進安宮	  (24.6333761,121.7120399) 24.633903 121.7120371
        else if(locationX>24.6333486 && locationX<24.6335086 && locationY>121.7120467 && locationY<121.7122267){
            boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage4_chance",false);
            if (chance){
                setDis(4);
                alertDialog();
                button_start.setText(R.string.stage_dis);
            }else{
                setDis(4);
                button_start.setText(R.string.start1);
                button_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent=new Intent(Map.this,Stage4.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
        //神隱村	(24.6314 424,121.7119 747)24.6314154 121.7119814
        else if(locationX>24.63139 && locationX<24.63143 && locationY>121.71196&& locationY<121.7120){
            boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage5_chance",false);
            if (chance){
                setDis(5);
                alertDialog();
                button_start.setText(R.string.stage_dis);
            }else{
                setDis(5);
                button_start.setText(R.string.start1);
                button_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent=new Intent(Map.this,Stage5.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
        //松茂果園	(24.6240 ,121.7095 )6214949 7030826 6192 7008413
        else if(locationX>24.63254 && locationX<24.63270 && locationY> 121.71241 && locationY< 121.71257){
            boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage6_chance",false);
            if (chance){
                setDis(6);
                alertDialog();
                button_start.setText(R.string.stage_dis);
            }else{
                setDis(6);
                button_start.setText(R.string.start1);
                button_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent=new Intent(Map.this,Stage6.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
        //寒溪吊橋	(24.6105 418,121.6878 228)
        else if(locationX>24.6103 && locationX<24.6107 && locationY> 121.6876 && locationY< 121.6880){
            boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage7_chance",false);
            if (chance){
                setDis(7);
                alertDialog();
                button_start.setText(R.string.stage_dis);
            }else{
                setDis(7);
                button_start.setText(R.string.start1);
                button_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent=new Intent(Map.this,Stage7.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
        //劉記花生	(24.6328 35,121.7129 324)
        //春記麥芽酥	(24.6333 968,121.7132 163)
        //順進蜜餞行	(24.6334 287,121.7132 447)
        else if(locationX>24.6326 && locationX<24.6336 && locationY> 121.7127 && locationY< 121.7134){
            boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage8_chance",false);
            if (chance){
                setDis(8);
                alertDialog();
                button_start.setText(R.string.stage_dis);
            }else{
                setDis(8);
                button_start.setText("下一頁");
                button_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        setDis(9);
                        button_start.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                button_start.setText(R.string.stage_button);
                                setDis(10);
                                button_start.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        intent=new Intent(Map.this,Stage8.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                });
                            }
                        });
                    }
                });
            }
        }
        //嘉苳樹(24.6392 575,121.6944 971)
        else if(locationX>24.6390 && locationX<24.6394 && locationY> 121.6942 && locationY< 121.6946){
            boolean chance = getSharedPreferences("stage",MODE_PRIVATE).getBoolean("stage9_chance",false);
            if (chance){
                setDis(11);
                alertDialog();
                button_start.setText(R.string.stage_dis);
            }else{
                setDis(11);
                button_start.setText(R.string.start1);
                button_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        intent=new Intent(Map.this,Stage9.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        }
        else{
            imageView_stagepic.setImageResource(R.drawable.map);
            button_start.setText(R.string.GPS_wrong);
            Log.d("Test","Something wrong");
            Log.d("Test","X"+locationX);
            Log.d("Test","Y"+locationY);
        }

    }

    // set UI
    private void setDis(int i) {
        textView_title.setText(title[i]);
        textView_titleDis.setText(titleDis[i]);
        if(i==0){
            imageView_stagepic.setImageResource(R.drawable.pic1);
        }else if(i==1){
            imageView_stagepic.setImageResource(R.drawable.pic2);
        }else if(i==2){
            imageView_stagepic.setImageResource(R.drawable.pic3);
        }else if(i==3){
            imageView_stagepic.setImageResource(R.drawable.pic4);
        }else if(i==4){
            imageView_stagepic.setImageResource(R.drawable.pic5);
        }else if(i==5){
            imageView_stagepic.setImageResource(R.drawable.pic6);
        }else if(i==6){
            imageView_stagepic.setImageResource(R.drawable.pic7);
        }else if(i==7){
            imageView_stagepic.setImageResource(R.drawable.pic8);
        }else if(i==8){
            imageView_stagepic.setImageResource(R.drawable.pic91);
        }else if(i==9){
            imageView_stagepic.setImageResource(R.drawable.pic92);
        }else if(i==10){
            imageView_stagepic.setImageResource(R.drawable.pic93);
        }else if(i==11){
            imageView_stagepic.setImageResource(R.drawable.pic10);
        }


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

    private void updateLocation(Location location) {

        if (location != null) {
            locationX = location.getLatitude();
            textView_gpsX.setText("緯度 "+locationX);
            locationY  = location.getLongitude();
            textView_gpsY.setText("經度 "+locationY);
        }
    }

    private final LocationListener locationListener = new LocationListener() {
        public void onLocationChanged(Location location) {
            updateLocation(location);

        }
        public void onProviderDisabled(String provider){
            updateLocation(null);
        }
        public void onProviderEnabled(String provider){

        }
        public void onStatusChanged(String provider, int status,Bundle extras){

        }
    };


}