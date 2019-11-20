package com.example.enneadram.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.enneadram.Adapters.view_pager_adpt;
import com.example.enneadram.R;
import com.example.enneadram.Storage.SharedPrefranceManager;

public class Introduction_activity extends AppCompatActivity {

    private ViewPager viewPager;
    private view_pager_adpt pager_adpt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
        viewPager=findViewById(R.id.v_pager);

        pager_adpt=new view_pager_adpt(this);


        if(SharedPrefranceManager.getInastance(this).isFirstTime()){
            viewPager.setAdapter(pager_adpt);
        }else {
            startActivity(new Intent(Introduction_activity.this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK));
            finish();
        }

    }
}
