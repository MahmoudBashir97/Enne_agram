package com.example.enneadram.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.enneadram.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class Question_4_Activity extends AppCompatActivity {

    public Button Next_btn;
    public ToggleButton ch_1,ch_2,ch_3,ch_4,ch_5,ch_6,ch_7,ch_8;
    AppCompatCheckBox del_1,del_2,del_3,del_4,del_5,del_6,del_7,del_8;

    String intentvalue;
    int points=0;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_4_);
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





        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6866381333968774/2186925890");
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);



        //receive grade points from previous checkbox
        intentvalue=getIntent().getStringExtra("points");
        points= Integer.parseInt(intentvalue);

        right_check();


        Next_btn.setOnClickListener(view -> {

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {

                Intent intent=new Intent(Question_4_Activity.this, Question_5_Activity.class);

                intent.putExtra("points",points+"");
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

                //Toast.makeText(this, "Please Check your Internet Connection.", Toast.LENGTH_SHORT).show();

                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        });
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                //mInterstitialAd.loadAd(new AdRequest.Builder().build());
                Intent intent=new Intent(Question_4_Activity.this, Question_5_Activity.class);
                intent.putExtra("points",points+"");
                startActivity(intent);
                finish();
            }

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
