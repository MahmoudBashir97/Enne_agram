package com.example.enneadram.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.enneadram.Fragments.ProfileFragment;
import com.example.enneadram.R;

public class Crush_types extends AppCompatActivity {

    ImageButton back_btn;
    String kind_Type="";
    TextView txt_1,txt_2,txt_3,txtDesc_1,txtDesc_2,txtDesc_3;
    ImageView img_1,img_2,img_3;
    int C1,C2,C3;

    public String[] lst_typesDesc={
            "You are a serious, prince some, idealistic, rational.\n"+
            "You do a job in full and in accordance, you are serious,\n"+
    "sensible and controlling, responsive in responsibilities,\n"+
    "You are regular and rigorous, self-disciplined, restrained.",
            "You’re romantic, caring, friendly, talkative, and easy-to-\n" +
                    "communicate.\n" +
                    "You show your feelings; you are helpful, generous,\n" +
                    "compassionate, friendly, caring. You care\n" +
                    "You’re friendly and supportive.",
            "You, who love to admire your personality and\n" +
                    "effectiveness, who likes to be successful and impressive,\n" +
                    "you’re hesitant, business-oriented, pragmatic, and highly\n" +
                    "you’re competitive and confident.",
            "Your emotional side is stronger, but you don’t reveal your\n" +
                    "feelings that are romantic, sensitive, caring, and honest.\n" +
                    "You are intuitive and have deep insight, looking for\n" +
                    "meaning and depth. You are authentic, gentle, delicate,\n" +
                    "individuality-loving, aesthetic, and, strong.",
            "You are a rational, curious, and abstract thinker with\n" +
                    "looking in depth of the information.\n" +
                    "You’re usually introvert, not disturbed by being alone.\n" +
                    "Deeply curious and specialized, logical and analytical,\n" +
                    "knowledge-loving, relentless, and objective.",
            "You need to feel confident and safe.\n" +
                    "You’re a cautious, curious, and interrogative! Trust and\n" +
                    "safety are an essential part of your personality.\n" +
                    "You are questioning and controlling all the possibilities,\n" +
                    "sensitive to mutual responsibilities,and wondering the details.",
            "You’re an optimistic, unfit, emotionally-incompetent\n" +
                    "person who likes to explore and experience new things.\n" +
                    "You are curious and you mental associations are intense.\n" +
                    "You are focused, fun and cheerful, spontaneous and fast,\n" +
                    "engaged and talkative, not worn to the past and the pain.",
            "You are brave, decisive, confident, and authoritarian.\n" +
                    "You’re the one who cares about being strong and\n" +
                    "independent."+
                   "You’re strict and dominant, competitive, and\n" +
                    "authoritarian.",
            "Your patience, which prioritizes peace and reconciliation,\n" +
                    "seeks harmony and peace. You’re a man who avoids\n" +
                    "conflict and tension. Peace and tranquility presuppose\n" +
                    "you. You are calm and controlled in the reactions, soft-\n" +
                    "tempered .You’re fond of physical comfort.",
            "Your patience, which prioritizes peace and reconciliation,\n" +
                    "seeks harmony and peace. You’re a man who avoids\n" +
                    "conflict and tension. Peace and tranquility presuppose\n" +
                    "you. You are calm and controlled in the reactions, soft-\n" +
                    "tempered and harmonious,You’re fond of physical comfort."
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crush_types);
        back_btn=findViewById(R.id.back_btn);
        txt_1=findViewById(R.id.txt_1);
        txt_2=findViewById(R.id.txt_2);
        txt_3=findViewById(R.id.txt_3);
        img_1=findViewById(R.id.img_1);
        img_2=findViewById(R.id.img_2);
        img_3=findViewById(R.id.img_3);


        txtDesc_1=findViewById(R.id.txtDesc_1);
        txtDesc_2=findViewById(R.id.txtDesc_2);
        txtDesc_3=findViewById(R.id.txtDesc_3);




        C1= Integer.parseInt(getIntent().getStringExtra("C1"));
        C2= Integer.parseInt(getIntent().getStringExtra("C2"));
        C3= Integer.parseInt(getIntent().getStringExtra("C3"));



        if (C1==1){
            txt_1.setText("Type 1");
            txtDesc_1.setText(lst_typesDesc[0]);
            img_1.setImageResource(R.drawable.tip1);
        } else if (C1==2) {
            txt_1.setText("Type 2");
            txtDesc_1.setText(lst_typesDesc[1]);
            img_1.setImageResource(R.drawable.tip2);
        }else if (C1==3) {
            txt_1.setText("Type 3");
            txtDesc_1.setText(lst_typesDesc[2]);
            img_1.setImageResource(R.drawable.tip3);
        }else if (C1==4) {
            txt_1.setText("Type 4");
            txtDesc_1.setText(lst_typesDesc[3]);
            img_1.setImageResource(R.drawable.tip4);
        }else if (C1==5) {
            txt_1.setText("Type 5");
            txtDesc_1.setText(lst_typesDesc[4]);
            img_1.setImageResource(R.drawable.tip5);
        }

        if (C2==3){
            txt_2.setText("Type 3");
            txtDesc_2.setText(lst_typesDesc[2]);
            img_2.setImageResource(R.drawable.tip3);
        } else if (C2==4) {
            txt_2.setText("Type 4");
            txtDesc_2.setText(lst_typesDesc[3]);
            img_2.setImageResource(R.drawable.tip4);
        }else if (C2==5) {
            txt_2.setText("Type 5");
            txtDesc_2.setText(lst_typesDesc[4]);
            img_2.setImageResource(R.drawable.tip5);
        }else if (C2==6) {
            txt_2.setText("Type 6");
            txtDesc_2.setText(lst_typesDesc[5]);
            img_2.setImageResource(R.drawable.tip6);
        }else if (C2==8) {
            txt_2.setText("Type 8");
            txtDesc_2.setText(lst_typesDesc[7]);
            img_2.setImageResource(R.drawable.tip8);
        }

        if (C3==4){
            txt_3.setText("Type 4");
            txtDesc_3.setText(lst_typesDesc[3]);
            img_3.setImageResource(R.drawable.tip4);
        } else if (C3==7) {
            txt_3.setText("Type 7");
            txtDesc_3.setText(lst_typesDesc[6]);
            img_3.setImageResource(R.drawable.tip7);
        }else if (C3==9) {
            txt_3.setText("Type 9");
            txtDesc_3.setText(lst_typesDesc[8]);
            img_3.setImageResource(R.drawable.tip9);
        }else if (C3==5) {
            txt_3.setText("Type 5");
            txtDesc_3.setText(lst_typesDesc[4]);
            img_3.setImageResource(R.drawable.tip5);
        }else if (C3==8) {
            txt_3.setText("Type 8");
            txtDesc_3.setText(lst_typesDesc[7]);
            img_3.setImageResource(R.drawable.tip8);
        }


        back_btn.setOnClickListener(view -> {
            startActivity(new Intent(Crush_types.this, MainActivity.class));
        });
    }
    public void Kind_type(){
              if (kind_Type.equals("Type-1")){
                  Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
        }else if (kind_Type.equals("Type-2")){
                  Toast.makeText(this, "Type-1", Toast.LENGTH_SHORT).show();
        }else if (kind_Type.equals("Type-3")){
                  Toast.makeText(this, "Type-1", Toast.LENGTH_SHORT).show();
        }else if (kind_Type.equals("Type-4")){
                  Toast.makeText(this, "Type-1", Toast.LENGTH_SHORT).show();
        }else if (kind_Type.equals("Type-5")){
                  Toast.makeText(this, "Type-1", Toast.LENGTH_SHORT).show();
        }else if (kind_Type.equals("Type-6")){
                  Toast.makeText(this, "Type-1", Toast.LENGTH_SHORT).show();
        }else if (kind_Type.equals("Type-7")){
                  Toast.makeText(this, "Type-1", Toast.LENGTH_SHORT).show();
        }else if (kind_Type.equals("Type-8")){
                  Toast.makeText(this, "Type-1", Toast.LENGTH_SHORT).show();
        }else if (kind_Type.equals("Type-9")){
                  Toast.makeText(this, "Type-1", Toast.LENGTH_SHORT).show();
        }
    }
}
