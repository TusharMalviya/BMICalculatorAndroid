package com.example.bmi_calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtHeightFt, edtHeightIn, edtWeight;
        AppCompatButton btnButton;
        TextView result;
        LinearLayout mainLinear;

        edtWeight=findViewById(R.id.edtWeight);
        edtHeightFt=findViewById(R.id.edtHeightFt);
        edtHeightIn=findViewById(R.id.edtHeightIn);
        btnButton=findViewById(R.id.bdtButton);
        result=findViewById(R.id.result);
        mainLinear=findViewById(R.id.mainLinear);

        btnButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                int wt= Integer.parseInt(edtWeight.getText().toString());
                int ft= Integer.parseInt(edtHeightFt.getText().toString());
                int in= Integer.parseInt(edtHeightIn.getText().toString());

                int totalIn= ft*12 + in;
                double totalcm= totalIn*2.53;
                double total=totalcm/100;
                double BMI=wt/(total*total);

                if(BMI>25){
                    result.setText("You're OverWeight");
                    mainLinear.setBackgroundColor(getResources().getColor(R.color.overWeight));
                } else if (BMI<18) {
                    result.setText("You're UnderWeight");
                    mainLinear.setBackgroundColor(getResources().getColor(R.color.underWeight));
                }
                else {
                    result.setText("You're Healthy");
                    mainLinear.setBackgroundColor(getResources().getColor(R.color.healthy));
                }
            }
        });
    }
}