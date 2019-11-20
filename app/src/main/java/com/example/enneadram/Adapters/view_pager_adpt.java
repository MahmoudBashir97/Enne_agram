package com.example.enneadram.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.enneadram.Storage.SharedPrefranceManager;
import com.example.enneadram.ui.Introduction_activity;
import com.example.enneadram.R;
import com.example.enneadram.ui.MainActivity;
import com.example.enneadram.ui.intro_third;

public class view_pager_adpt extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public view_pager_adpt(Context context) {
        this.context = context;
    }

    //list of images
    public int[] lst_imgs={
            R.drawable.polygonicon,
            R.drawable.scaleicon
    };

    //list of main text with Questions
    public String[] lst_mainQ={
            "What is it?",
            "We are not the same but equivalent."

    };

    //lis of descriptions
    public String[] lst_desc={
            "   Enneagram is the powerful and \n" +
                    "defining model of person's emotions,\n" +
                    "            ideas, and actions.",
            "Find out how harmonious you are with\n" +
                    "   your friends. Check out advises on \n" +
                    "   your daily routines and your attitude in \n" +"       "+
                    "                      relationships."
    };

    //list of piece next
    public int[] lst_piece={
            R.drawable.peace_back,
            R.drawable.peace_back,
            R.drawable.peace_back
    };


    @Override
    public int getCount() {
        return lst_mainQ.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(RelativeLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v=layoutInflater.inflate(R.layout.intro_slide,container,false);

        RelativeLayout slide_relative=v.findViewById(R.id.slide_Relative);
        ImageView intro_logo=v.findViewById(R.id.img_v);
        TextView txt_1=v.findViewById(R.id.txt_1);
        TextView txt_2=v.findViewById(R.id.txt_2);
        ImageView v1=v.findViewById(R.id.v1);
        Button skip=v.findViewById(R.id.skip);

        //set btn INVISIBLE by GONE
        skip.setVisibility(View.GONE);


        intro_logo.setImageResource(lst_imgs[position]);
        txt_1.setText(lst_mainQ[position]);
        txt_2.setText(lst_desc[position]);

        if (position==0){

            v1.setImageResource(R.drawable.navigation1);

        }else if (position==1){

            v1.setImageResource(R.drawable.navigation2);

            skip.setVisibility(View.VISIBLE);
            skip.setOnClickListener(V -> {
                Intent intent=new Intent(context, intro_third.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
                ((Introduction_activity)context).finish();
            });
        }else {
            v1.setImageResource(R.drawable.peace_back);
        }

        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
