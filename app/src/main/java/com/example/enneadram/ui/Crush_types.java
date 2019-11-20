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
    TextView txt_1,txt_2,txt_3;
    ImageView img_1,img_2,img_3;
    int C1,C2,C3;
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


        C1= Integer.parseInt(getIntent().getStringExtra("C1"));
        C2= Integer.parseInt(getIntent().getStringExtra("C2"));
        C3= Integer.parseInt(getIntent().getStringExtra("C3"));

        if (C1==1){
            txt_1.setText("Type 1");
            img_1.setImageResource(R.drawable.tip1);
        } else if (C1==2) {
            txt_1.setText("Type 2");
            img_1.setImageResource(R.drawable.tip2);
        }else if (C1==3) {
            txt_1.setText("Type 3");
            img_1.setImageResource(R.drawable.tip3);
        }else if (C1==4) {
            txt_1.setText("Type 4");
            img_1.setImageResource(R.drawable.tip4);
        }else if (C1==5) {
            txt_1.setText("Type 5");
            img_1.setImageResource(R.drawable.tip5);
        }

        if (C2==3){
            txt_2.setText("Type 3");
            img_2.setImageResource(R.drawable.tip3);
        } else if (C2==4) {
            txt_2.setText("Type 4");
            img_2.setImageResource(R.drawable.tip4);
        }else if (C2==5) {
            txt_2.setText("Type 5");
            img_2.setImageResource(R.drawable.tip5);
        }else if (C2==6) {
            txt_2.setText("Type 6");
            img_2.setImageResource(R.drawable.tip6);
        }else if (C2==8) {
            txt_2.setText("Type 8");
            img_2.setImageResource(R.drawable.tip8);
        }

        if (C3==4){
            txt_3.setText("Type 4");
            img_3.setImageResource(R.drawable.tip4);
        } else if (C3==7) {
            txt_3.setText("Type 7");
            img_3.setImageResource(R.drawable.tip7);
        }else if (C3==9) {
            txt_3.setText("Type 9");
            img_3.setImageResource(R.drawable.tip9);
        }else if (C3==5) {
            txt_3.setText("Type 5");
            img_3.setImageResource(R.drawable.tip5);
        }else if (C3==8) {
            txt_3.setText("Type 8");
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
