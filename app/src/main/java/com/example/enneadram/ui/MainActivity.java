package com.example.enneadram.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.android.billingclient.api.BillingClient;
import com.example.enneadram.Adapters.view_pager_adpt;
import com.example.enneadram.Fragments.EnneagramFragment;
import com.example.enneadram.Fragments.ProfileFragment;
import com.example.enneadram.Fragments.SettingsFragment;
import com.example.enneadram.R;
import com.example.enneadram.Storage.SharedPrefranceManager;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
implements NavigationView.OnNavigationItemSelectedListener {

    private Fragment frag;
    private BottomNavigationView mainnav;
    FrameLayout mainframe;
    String intentvalue;
    int points=0;
    String type="";

    public AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, "ca-app-pub-6866381333968774~1256987606");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
            }

            @Override
            public void onAdLeftApplication() {
                super.onAdLeftApplication();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }
        });

        //receive sum of grade points from previous checkbox
        intentvalue=getIntent().getStringExtra("points");
       // points= Integer.parseInt(intentvalue);
        points= Integer.parseInt(SharedPrefranceManager.getInastance(this).getPoints());

        check_types();


        mainframe=(FrameLayout) findViewById(R.id.main_frame);
        mainnav=(BottomNavigationView) findViewById(R.id.main_nav);

        mainnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch(item.getItemId()){

                    case R.id.nav_home:

                        frag=new EnneagramFragment();
                        setFragment(frag);
                        return true;
                    case R.id.nav_profile:

                        frag=new ProfileFragment(type);
                        setFragment(frag);
                        return true;
                    case R.id.nav_settings:

                        frag=new SettingsFragment();
                        setFragment(frag);
                        return true;
                }
                return false;
            }
        });

        mainnav.setSelectedItemId(R.id.nav_profile);

    }

    private void setFragment(Fragment frag) {
        FragmentManager Fragmang=getSupportFragmentManager();
        FragmentTransaction Fragtr=Fragmang.beginTransaction();
        Fragtr.replace(R.id.main_frame,frag);
        Fragtr.commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        int id=item.getItemId();
        if(id==R.id.nav_home){
            Toast.makeText(this, "home", Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.nav_profile){
            Toast.makeText(this,"profile",Toast.LENGTH_SHORT).show();
        }
        if (id==R.id.nav_settings){
            Toast.makeText(this,"Settigs",Toast.LENGTH_SHORT).show();
        }


        return false;
    }

    public void check_types(){

        if (points<=15){
            type="Type-1";
        }else if (points>=16 && points<=20){
            type="Type-2";
        }else if (points>=21&& points<=26){
            type="Type-3";
        }else if (points>=27 && points<=30){
            type="Type-4";
        }else if (points>=31 && points<=35){
            type="Type-5";
        }else if (points>=36 && points<=39){
            type="Type-6";
        }else if (points>=40 && points<=43){
            type="Type-7";
        }else if (points>=44 && points<=49){
            type="Type-8";
        }
    }
}
