package com.example.enneadram.Fragments;


import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.enneadram.R;
import com.example.enneadram.ui.MainActivity;
import com.example.enneadram.ui.intro_Questions;
import com.example.enneadram.ui.intro_third;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class SettingsFragment extends Fragment {
    View v;
    Button retest_btn;
    private InterstitialAd mInterstitialAd;
    private RelativeLayout Relat_share,Relat_rate;

    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_settings, container, false);
        retest_btn=v.findViewById(R.id.retest_btn);
        Relat_share=v.findViewById(R.id.Relat_share);
        Relat_rate=v.findViewById(R.id.Relat_rate);

        MobileAds.initialize(getContext(),
                "ca-app-pub-3940256099942544~3347511713");
        mInterstitialAd = new InterstitialAd(getContext());
        mInterstitialAd.setAdUnitId("ca-app-pub-6866381333968774/7247680886");
        AdRequest adRequest = new AdRequest.Builder().build();
        mInterstitialAd.loadAd(adRequest);


        //to share this app with friends with link google play
        Relat_share.setOnClickListener(view -> {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My App Name");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Share this App with");
            startActivity(Intent.createChooser(sendIntent, "Share app via"));
        });
        Relat_rate.setOnClickListener(view -> {
            rateMe(view);
        });


        retest_btn.setOnClickListener(view -> {

            if (mInterstitialAd.isLoaded()) {
                mInterstitialAd.show();
            } else {
                Toast.makeText(getContext(), "Please Check your Internet Connection.", Toast.LENGTH_SHORT).show();

                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        });



        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                //mInterstitialAd.loadAd(new AdRequest.Builder().build());
                Intent intent=new Intent(getContext(), intro_third.class);
                startActivity(intent);
                getActivity().finish();
            }

        });

        return v;
    }

    public void rateMe(View view) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" +getContext().getPackageName() )));
        } catch (android.content.ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getContext().getPackageName())));
        }
    }
}
