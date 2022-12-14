package com.example.calculator_interf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private String input_1, input_2, input_3, input_4, answer;
    private String data="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen=findViewById(R.id.screen);
    }

    public void onClick(View v) {
        screen.setText(data);
        Button btn=(Button) v;
        //data= btn.getText().toString();
        switch (v.getId()){
            case (R.id.enter):
                input_4 = input_3;
                input_3 = input_2;
                input_2 = input_1;
                input_1 = data;
                break;
            case (R.id.chs):
                data= String.valueOf(-1*(Double.parseDouble(data)));
                break;
            case (R.id.eex):
                break;
            case (R.id.clx):
                if (input_1.equals(data)){
                    data="0";
                    input_1="0";
                } else {
                String new_string=data.substring(0,data.length()-1);
                data=new_string;}
                break;
            case (R.id.one):
                data+="1";
                break;
            case (R.id.two):
                data+="2";
                break;
            case (R.id.three):
                data+="3";
                break;
            case (R.id.four):
                data+="4";
                break;
            case (R.id.five):
                data+="5";
                break;
            case (R.id.six):
                data+="6";
                break;
            case (R.id.seven):
                data+="7";
                break;
            case (R.id.eight):
                data+="8";
                break;
            case (R.id.nine):
                data+="9";
                break;
            case (R.id.zero):
                data+="0";
                break;
            case (R.id.dot):
                data+=",";
                break;
            case (R.id.r_s):
                break;
            case (R.id.subt):
                solve(1);
                break;
            case (R.id.plus):
                solve(2);
                break;
            case (R.id.mult):
                solve(3);
                break;
            case (R.id.div):
                solve(4);
                break;
            default:
               // data+= btn.getText().toString();
        }
        screen.setText(data);
    }
    public void solve(int x){
        switch (x){
            case 1:
                data=String.valueOf((Double.parseDouble(input_1))-(Double.parseDouble(input_2)));
                break;
            case 2:
                data=String.valueOf((Double.parseDouble(input_1))+(Double.parseDouble(input_2)));
                break;
            case 3:
                data=String.valueOf((Double.parseDouble(input_1))*(Double.parseDouble(input_2)));
                break;
            case 4:
                //answer=String.valueOf((Double.parseDouble(input_1))/(Double.parseDouble(input_2)));
                data=(Double.parseDouble(input_1))/(Double.parseDouble(input_2))+"";
                break;
        }
        input_4="";
        input_3=input_4;
        input_2=input_3;
        input_1=data;

        screen.setText(input_1);
        data="0";

    }
}