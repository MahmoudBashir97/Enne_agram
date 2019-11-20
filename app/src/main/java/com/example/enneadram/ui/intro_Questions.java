package com.example.enneadram.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import com.example.enneadram.R;
import com.example.enneadram.Storage.SharedPrefranceManager;

public class intro_Questions extends AppCompatActivity {

    public Button Next_btn;
    public ToggleButton ch_1,ch_2,ch_3,ch_4,ch_5,ch_6,ch_7,ch_8;
    AppCompatCheckBox del_1,del_2,del_3,del_4,del_5,del_6,del_7,del_8;
    int check_val=0;
    public int points=0;
    Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.intro_questions);
        Next_btn=findViewById(R.id.Next_btn);
        ch_1=findViewById(R.id.ch_1);
        ch_2=findViewById(R.id.ch_2);
        ch_3=findViewById(R.id.ch_3);
        ch_4=findViewById(R.id.ch_4);
        ch_5=findViewById(R.id.ch_5);
        ch_6=findViewById(R.id.ch_6);
        ch_7=findViewById(R.id.ch_7);
        ch_8=findViewById(R.id.ch_8);

        right_check();



        Next_btn.setOnClickListener(view -> {
            Intent intent=new Intent(intro_Questions.this, Question_2_Activity.class);
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
