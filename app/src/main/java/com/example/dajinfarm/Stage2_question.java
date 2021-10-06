package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Stage2_question extends AppCompatActivity {

    Button button1,button2;
    TextView textView_question;
    String[] question = {
            "工蜂是雄性的蜜蜂，\n主要職責是採集花粉和花蜜來哺育蜂群，\n以及分泌用來修築蜂巢的蜂蠟。" ,
            "蜜蜂釀造蜂蜜只需要三天就可以熟成。" ,
            "蜜蜂的觸角主要做為嗅覺器官，\n可以偵測氣味跟分辨氣味傳來的方向。" ,
            "蜜蜂振翅是牠們發出獨特嗡嗡聲的來源。" ,
            "好蜜養蜂場的蜂農利用當地新鮮的水果\n幫蜜蜂補充營養。" ,
            "蜜蜂要採集兩百萬朵花的花蜜\n才能製成一磅的蜂蜜。" ,
            "蜂后的主要職責是產卵，\n以及透過散發化學氣味來控制蜂群。" ,
            "蜜蜂建造五角形的巢室可以用\n最少的材料製造出更寬敞的生活空間，\n同時承受住蜂蜜的重量。" ,
            "一個蜂群通常有三種成蜂，\n分別是工蜂、雄蜂和蜂后，\n他們都各司其職。" };
    Boolean[] answer ={false,false,true,true,false,true,true,false,true};

    Intent intent;
    int index;
    ImageView imageView_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage2_question);

        button1=findViewById(R.id.button_ans1);
        button2=findViewById(R.id.button_ans2);
        textView_question=findViewById(R.id.textView_question);

        imageView_button=findViewById(R.id.imageView_home);
        imageView_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage2_question.this);
                alertDialog.setTitle(R.string.back);
                alertDialog.setMessage(R.string.back_dis)
                        .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                                pref.edit()
                                        .putBoolean("stage2",false)
                                        .putBoolean("stage2_chance",true)
                                        .apply();

                                intent=new Intent(Stage2_question.this,Map.class);
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


        intent = getIntent();
        index=intent.getIntExtra("index",0);
        if(index==0){
            textView_question.setText(question[0]);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogFail();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogCorrect();
                }
            });
        }else if(index==2){
            textView_question.setText(question[1]);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogFail();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogCorrect();
                }
            });
        }else if(index==4){
            textView_question.setText(question[2]);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogCorrect();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogFail();
                }
            });
        }else if(index==5){
            textView_question.setText(question[3]);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogCorrect();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogFail();
                }
            });
        }else if(index==8){
            textView_question.setText(question[4]);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogFail();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogCorrect();
                }
            });
        }else if(index==9){
            textView_question.setText(question[5]);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogCorrect();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogFail();
                }
            });
        }else if(index==11){
            textView_question.setText(question[6]);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogCorrect();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogFail();
                }
            });
        }else if(index==13){
            textView_question.setText(question[7]);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogFail();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogCorrect();
                }
            });
        }else if(index==14){
            textView_question.setText(question[8]);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogCorrect();
                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertDialogFail();
                }
            });
        }
    }

    // wrong dialog
    private void alertDialogFail() {
        int wrong = getSharedPreferences("stage",MODE_PRIVATE).getInt("stage2_wrong",0);
        SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
        pref.edit()
                .putInt("stage2_wrong",(wrong+1))
                .apply();

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage2_question.this);
        alertDialog.setTitle("");
        alertDialog.setMessage(R.string.ans_error)
                .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }
    // right dialog
    private void alertDialogCorrect() {
        int right = getSharedPreferences("stage",MODE_PRIVATE).getInt("stage2_right",0);
        SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
        pref.edit()
                .putInt("stage2_right",(right+1))
                .apply();

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage2_question.this);
        alertDialog.setTitle("");
        alertDialog.setMessage(R.string.ans_right)
                .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .setCancelable(false)
                .show();
    }


}