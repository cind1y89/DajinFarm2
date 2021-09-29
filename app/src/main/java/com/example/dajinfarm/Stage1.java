package com.example.dajinfarm;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Stage1 extends AppCompatActivity {

    TextView textView_amount,textView_clear,
            textView0,textView1,textView2,
            textView3,textView4,textView5,
            textView6,textView7,textView8,
            textView9,textView_add,textView_minus,
            textView_mult,textView_div,textView_equal;

    Button button_start;
    Intent intent;

    private static StringBuilder show_equation;//顯示運算式
    private static ArrayList calculate_equation;//計算式

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage1);

        //cal 初始化
        show_equation=new StringBuilder();
        calculate_equation=new ArrayList<>();
        textView0 = findViewById(R.id.textView_num0);
        textView1=findViewById(R.id.textView_num1);
        textView2=findViewById(R.id.textView_num2);
        textView3=findViewById(R.id.textView_num3);
        textView4=findViewById(R.id.textView_num4);
        textView5=findViewById(R.id.textView_num5);
        textView6=findViewById(R.id.textView_num6);
        textView7=findViewById(R.id.textView_num7);
        textView8=findViewById(R.id.textView_num8);
        textView9=findViewById(R.id.textView_num9);
        textView_clear=findViewById(R.id.textView_clear);
        textView_div=findViewById(R.id.textView_div);
        textView_minus=findViewById(R.id.textView_minus);
        textView_add=findViewById(R.id.textView_add);
        textView_mult=findViewById(R.id.textView_mult);
        textView_equal =findViewById(R.id.textView_equal);
        textView_amount=findViewById(R.id.textView_amount);

        textView0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if(!(show_equation.equals("0"))){
                    show_equation.append("0");
                    textView_amount.setText(show_equation);
                }
            }
        });
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("1");
                textView_amount.setText(show_equation);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("2");
                textView_amount.setText(show_equation);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("3");
                textView_amount.setText(show_equation);
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("4");
                textView_amount.setText(show_equation);
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("5");
                textView_amount.setText(show_equation);
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("6");
                textView_amount.setText(show_equation);
            }
        });
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("7");
                textView_amount.setText(show_equation);
            }
        });
        textView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("8");
                textView_amount.setText(show_equation);
            }
        });
        textView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("9");
                textView_amount.setText(show_equation);
            }
        });
        textView_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.delete(0,show_equation.length());
                calculate_equation.clear();
                textView_amount.setText("");
            }
        });
        textView_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show_equation.charAt(0)=='-')
                    show_equation.insert(0,"0");
                StringBuilder temp1=new StringBuilder();
                for(int i=0;i<show_equation.length();i++){
                    if(show_equation.charAt(i)>='0'&&show_equation.charAt(i)<='9'||show_equation.charAt(i)=='.'){
                        temp1.append(String.valueOf(show_equation.charAt(i)));
                    }
                    else
                    {
                        calculate_equation.add(temp1.toString());
                        temp1.delete(0,temp1.length());
                        calculate_equation.add(String.valueOf(show_equation.charAt(i)));
                    }
                }
                calculate_equation.add(temp1.toString());
                calculate_equation.add("#");
                String temp8=calculate(calculate_equation);
                textView_amount.setText(temp8);
            }
        });
        textView_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("+");
                textView_amount.setText(show_equation);
            }
        });
        textView_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("-");
                textView_amount.setText(show_equation);
            }
        });
        textView_mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("*");
                textView_amount.setText(show_equation);
            }
        });
        textView_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_equation.append("/");
                textView_amount.setText(show_equation);
            }
        });

        // intent
        button_start=findViewById(R.id.button_start);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textView_amount.getText().toString().equals("")){
                    AlertDialog.Builder alertDialog=new AlertDialog.Builder(Stage1.this);
                    alertDialog.setTitle("");
                    alertDialog.setMessage(R.string.stage1_dis)
                            .setPositiveButton(getString(R.string.button_yes), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            })
                            .setCancelable(false)
                            .show();

                }else{
                    SharedPreferences pref = getSharedPreferences("stage", MODE_PRIVATE);
                    pref.edit()
                            .putBoolean("stage1",true)
                            .putBoolean("stage1_chance",true)
                            .apply();

                    intent=new Intent(Stage1.this,Map.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }

    protected boolean operatorPriorityCompare(char operator1,char operator2)
    {
        int o1=0;
        int o2=0;
        switch (operator1){
            case '+':{o1=0;break;}
            case '-':{o1=0;break;}
            case '*':{o1=1;break;}
            case '/':{o1=1;break;}
        }
        switch (operator2){
            case '+':{o2=0;break;}
            case '-':{o2=0;break;}
            case '*':{o2=1;break;}
            case '/':{o2=1;break;}
        }
        if(o1<=o2)
        {
            return false;
        }
        else
            return true;
    }

    protected String calculate(ArrayList equation){
        Double temp2;
        Double temp3;
        Double textView_amount;
        ArrayList operator=new ArrayList();
        ArrayList operand=new ArrayList();
        for(int i=0;i<equation.size();i++)
        {
            String temp4=(String) equation.get(i);
            if(temp4.equals("+")||temp4.equals("-")||temp4.equals("*")||temp4.equals("/"))
            {
                if(operator.size()>0)
                {
                    String temp5=operator.get(operator.size()-1).toString();
                    while(!(operatorPriorityCompare(temp4.charAt(0),temp5.charAt(0)))&&operator.size()>0)
                    {
                        operator.remove(operator.size()-1);
                        temp3=(Double.parseDouble(operand.get(operand.size()-1).toString()));
                        operand.remove(operand.size()-1);
                        temp2=(Double.parseDouble(operand.get(operand.size()-1).toString()));
                        operand.remove(operand.size()-1);
                        switch (temp5.charAt(0))
                        {
                            case '+':{textView_amount=temp2+temp3;operand.add(String.valueOf(textView_amount));break;}
                            case '-':{textView_amount=temp2-temp3;operand.add(String.valueOf(textView_amount));break;}
                            case '*':{textView_amount=temp2*temp3;operand.add(String.valueOf(textView_amount));break;}
                            case '/':{textView_amount=temp2/temp3;operand.add(String.valueOf(textView_amount));break;}
                        }
                        if(operator.size()>0)
                        {
                            temp5=operator.get(operator.size()-1).toString();
                        }
                        else
                            break;
                    }
                    operator.add(temp4);
                }
                else
                    operator.add(temp4);
            }
            else if (temp4.equals("#"))
            {
                while (operator.size()>0)
                {
                    String temp6 = (String)operator.get(operator.size()-1);
                    operator.remove(operator.size()-1);
                    temp3 = (Double.parseDouble(operand.get(operand.size()-1).toString()));
                    operand.remove(operand.size()-1);
                    temp2 = (Double.parseDouble(operand.get(operand.size()-1).toString()));
                    operand.remove(operand.size()-1);
                    switch (temp6.charAt(0))
                    {
                        case '+' :{textView_amount=temp2+temp3;operand.add((String.valueOf(textView_amount)));break;}
                        case '/' :{textView_amount=temp2/temp3;operand.add((String.valueOf(textView_amount)));break;}
                        case '-' :{textView_amount=temp2-temp3;operand.add((String.valueOf(textView_amount)));break;}
                        case '*' :{textView_amount=temp2*temp3;operand.add((String.valueOf(textView_amount)));break;}
                    }
                }
            }
            else
            {
                operand.add(temp4);
            }

        }
        return operand.get(0).toString();

    }
}