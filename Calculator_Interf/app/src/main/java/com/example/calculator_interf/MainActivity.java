package com.example.calculator_interf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView screen;
    private static String input_1="0", input_2="0", input_3="0", input_4="0", answer;
    private static String data="0";
    private boolean new_data=true, use_solve=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        screen=findViewById(R.id.screen);
    }

    public void onClick(View v) {
        Button btn=(Button) v;
        switch (v.getId()){
            case (R.id.enter):
                intro_data(data);
                break;
            case (R.id.chs):
                data= String.valueOf(-1*(Double.parseDouble(data)));
                break;
            case (R.id.eex):
                break;
            case (R.id.clx):
                if (data.equals(input_1)||use_solve){
                    data="0";
                    new_data = true;
                    use_solve=false;
                }else {
                    if (data.length()==1) {
                        data = "0";
                        new_data = true;
                    }else{
                        data = data.substring(0, data.length() - 1);
                }}
                break;
            case (R.id.dot):
                if (!(data.substring(data.length()-1)).equals(".")) {
                    data+=".";}
                //screen.setText(data.substring(data.length()-2));
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
                if (new_data){
                    if (data.equals("0")||(data.equals(input_1))||use_solve){
                        data="";
                    }
                    new_data=false;
                use_solve=false;}
               data+= btn.getText().toString();
        }
        screen.setText(data);
    }

    private void intro_data(String data) {
        input_4 = input_3;
        input_3 = input_2;
        input_2 = input_1;
        input_1 = data;
        new_data=true;
        data="0";
    }

    public void solve(int x){
        //intro_data(data);
        use_solve=true;
        switch (x){
            case 1:
                data=String.valueOf((Double.parseDouble(input_1))-(Double.parseDouble(data)));
                break;
            case 2:
                data=String.valueOf((Double.parseDouble(input_1))+(Double.parseDouble(data)));
                break;
            case 3:
                data=String.valueOf((Double.parseDouble(input_1))*(Double.parseDouble(data)));
                break;
            case 4:
               try {
                data = (Double.parseDouble(input_1)) / (Double.parseDouble(data)) + "";
                }catch (Exception e) {
                    screen.setText("ERROR ---No se puede dividir entre 0");
                }
                break;
        }
        input_1=input_2;
        input_2=input_3;
        input_3=input_4;
        input_4="0";

        screen.setText(data);

    }
}