package com.example.enneadram.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;

import com.example.enneadram.R;
import com.example.enneadram.Storage.SharedPrefranceManager;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class intro_third extends AppCompatActivity {
    public Button start_btn;
    public ImageView img_v;
    public TextView txt_1,txt_2;

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_third);
        img_v=findViewById(R.id.img_v);
        start_btn=findViewById(R.id.start_btn);
        txt_1=findViewById(R.id.txt_1);
        txt_2=findViewById(R.id.txt_2);


        MobileAds.initialize(this,
                "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-6866381333968774/7439252572");
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);



        String Quest="Lets start the test!";
        String Desc= "What motivates you? What are your \n"+
                "focuses? How do you improve \n"+
                "yourself? Finishthe test and get the \n"+
                "          results!";

        img_v.setImageResource(R.drawable.papericon);
        txt_1.setText(Quest);
        txt_2.setText(Desc);

        start_btn.setOnClickListener(view -> {
            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }


        });
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                //mInterstitialAd.loadAd(new AdRequest.Builder().build());
                Intent intent=new Intent(intro_third.this, intro_Questions.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }

        });
    }
}
