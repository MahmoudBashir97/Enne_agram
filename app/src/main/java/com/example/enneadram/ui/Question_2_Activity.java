package com.example.enneadram.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.enneadram.R;

public class Question_2_Activity extends AppCompatActivity {

    public Button Next_btn;
    public ToggleButton ch_1,ch_2,ch_3,ch_4,ch_5,ch_6,ch_7,ch_8;
    ToggleButton del_1,del_2,del_3,del_4,del_5,del_6,del_7,del_8,avg_1,avg_2,avg_3,avg_4,avg_5,avg_6,avg_7,avg_8;
    ImageView img_avg1;
    String intentvalue;
    int points=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_2_);
        Next_btn=findViewById(R.id.Next_btn);
        Next_btn=findViewById(R.id.Next_btn);

        ch_1=findViewById(R.id.ch_1);
        ch_2=findViewById(R.id.ch_2);
        ch_3=findViewById(R.id.ch_3);
        ch_4=findViewById(R.id.ch_4);
        ch_5=findViewById(R.id.ch_5);
        ch_6=findViewById(R.id.ch_6);
        ch_7=findViewById(R.id.ch_7);
        ch_8=findViewById(R.id.ch_8);


        //receive grade points from previous checkbox
        intentvalue=getIntent().getStringExtra("points");
        points= Integer.parseInt(intentvalue);


        right_check();


        Next_btn.setOnClickListener(view -> {
            Intent intent=new Intent(Question_2_Activity.this, Question_3_Activity.class);
            intent.putExtra("points",points+"");
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
    public void right_check(){

        ch_1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    points=points+1;
                }else{
                    points=points;
                }
            }
        });
        ch_2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    points=points+1;
                }else{
                    points=points;
                }
            }
        });
        ch_3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    points=points+1;
                }else{
                    points=points;
                }
            }
        });
        ch_4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    points=points+1;
                }else{
                    points=points;
                }
            }
        });
        ch_5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    points=points+1;
                }else{
                    points=points;
                }
            }
        });
        ch_6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    points=points+1;
                }else{
                    points=points;
                }
            }
        });
        ch_7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    points=points+1;
                }else{
                    points=points;
                }
            }
        });
        ch_8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    points=points+1;
                }else{
                    points=points;
                }
            }
        });

    }

}
