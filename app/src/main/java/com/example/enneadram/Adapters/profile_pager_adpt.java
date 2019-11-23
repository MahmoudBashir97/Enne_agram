package com.example.enneadram.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.android.billingclient.api.AcknowledgePurchaseResponseListener;
import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingFlowParams;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.example.enneadram.Billing.Billing_inapp;
import com.example.enneadram.R;

import java.util.Arrays;
import java.util.List;

public class profile_pager_adpt extends PagerAdapter  {

    Context context;
    LayoutInflater layoutInflater;
    public ImageView img_type ,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22,v23,v24;
    public TextView txt_type,slide_Q,slide_desc;
    List<SkuDetails> skuDetails;
    BillingClient billingClient;

    public profile_pager_adpt(Context context) {
        this.context = context;
    }
    //list of images
    public int[] lst_imgs={
            R.drawable.enneagram_logo
    };
    public int[] lst_tip={

            R.drawable.tip1,
            R.drawable.tip2,
            R.drawable.tip3,
            R.drawable.tip4,
            R.drawable.tip5,
            R.drawable.tip6,
            R.drawable.tip7,
            R.drawable.tip8,
            R.drawable.tip9,
            R.drawable.tip9
    };
    //list of main text with Questions
    public String[] lst_mainQ={
            "Which film character are you?",
            "Your actions when you are relaxed",
            "Your actions when you are stressed",
            "Your ideal relationship",
            "Your main fear",
            "Your attention direction",
            "Things you escape",
            "Your expectations from your surroundings",
            "Your main focus?",
            "Your main positive quality"
    };

    public String[] lst_Desc={
            "You are the main actor in the movie titled \"Big Lebowski\". Watch it and you will see yourself!",
            "You are active, interactive, talkative, and much more productive! You value your image and status in a\n" +
                    "more balanced way than before!",
            "You feel insecure, uncertain, and try to escape the reality around you. Sometimes you accuse people for\n" +
                    "no reason and your start getting suspicious about the people who claim to trust you.",
            "The ideal relationship for you is one where both parties approach each other by acknowledging each\n" +
                    "others needs. The energy in the relationship needs to be balanced out and neither too much nor too little.\n" +
                    "In general, you value compatibility a lot!",
            "You mainly fear being abandoned and left to your own devices. You also fear losing your comfort zone\n" +
                    "and being forced to do things that you do not value and dislike.",
            "Your attention directs towards making sure to understand everyone's mindset and needs. You try to\n" +
                    "sometimes please everyone around you and this makes you really tired.",
            "You make sure to ignore problems and try to stay away from them as much as possible. Most of the\n" +
                    "times this becomes a burden on your shoulders.",
            "Everything should be comforting and compatible!",
            "You do your best to make sure to balance your internal and external world. Your mom definitely knows\n" +
                    "this about you!",
            "Acceptance and compatibility"
    };

    public String[] lst_types={
            "Type 1",
            "Type 2",
            "Type 3",
            "Type 4",
            "Type 5",
            "Type 6",
            "Type 7",
            "Type 8",
            "Type 9",
            "Type 10",
    };
    public String[] lst_typesDesc={
            "You are a serious, prince some, idealistic, rational, and a\n" +
                    "perfectionist.\n" +
                    "You do a job in full and in accordance, you are serious,\n" +
                    "sensible and controlling, responsive in responsibilities,\n" +
                    "You are regular and rigorous, self-disciplined, restrained,\n" +
                    "and idealistic.",
            "You’re romantic, caring, friendly, talkative, and easy-to-\n" +
                    "communicate.\n" +
                    "You show your feelings; you are helpful, generous,\n" +
                    "compassionate, friendly, caring, and warm. You care\n" +
                    "about love and give importance to relationships.\n" +
                    "You’re friendly and supportive.",
            "You, who love to admire your personality and\n" +
                    "effectiveness, who likes to be successful and impressive,\n" +
                    "you’re hesitant, business-oriented, pragmatic, and highly\n" +
                    "motivated. You give importance to your status.\n" +
                    "you’re competitive and confident.",
            "Your emotional side is stronger, but you don’t reveal your\n" +
                    "feelings that are romantic, sensitive, caring, and honest.\n" +
                    "\n" +
                    "You are intuitive and have deep insight, looking for\n" +
                    "meaning and depth. You are authentic, gentle, delicate,\n" +
                    "individuality-loving, aesthetic, and, strong. You’re honest\n" +
                    "with yourself.",
            "You are a rational, curious, and abstract thinker with\n" +
                    "looking in depth of the information.\n" +
                    "You’re usually introvert, not disturbed by being alone.\n" +
                    "Deeply curious and specialized, logical and analytical,\n" +
                    "self-sufficient, well-observed and genuinely minded,\n" +
                    "knowledge-loving, relentless, and objective.",
            "You need to feel confident and safe.\n" +
                    "You’re a cautious, curious, and interrogative! Trust and\n" +
                    "safety are an essential part of your personality.\n" +
                    "You are questioning and controlling all the possibilities,\n" +
                    "sensitive to mutual responsibilities, and wondering the\n" +
                    "details. You are susceptible to errors and inconsistencies.",
            "You’re an optimistic, unfit, emotionally-incompetent\n" +
                    "person who likes to explore and experience new things.\n" +
                    "You are curious and you mental associations are intense.\n" +
                    "\n" +
                    "You are focused, fun and cheerful, spontaneous and fast,\n" +
                    "engaged and talkative, not worn to the past and the pain,\n" +
                    "You concentrate on practical thinking and solution.",
            "You are brave, decisive, confident, and authoritarian.\n" +
                    "You’ree the one who cares about being strong and\n" +
                    "independent. You are bold and confident,\n" +
                    "straightforward and stable, strong and durable, and\n" +
                    "intervening. You’re strict and dominant, competitive, and\n" +
                    "authoritarian.",
            "Your patience, which prioritizes peace and reconciliation,\n" +
                    "seeks harmony and peace. You’re a man who avoids\n" +
                    "conflict and tension. Peace and tranquility presuppose\n" +
                    "you. You are calm and controlled in the reactions, soft-\n" +
                    "tempered and harmonious, patient and prolonging.\n" +
                    "You’re fond of physical comfort.",
            "Your patience, which prioritizes peace and reconciliation,\n" +
                    "seeks harmony and peace. You’re a man who avoids\n" +
                    "conflict and tension. Peace and tranquility presuppose\n" +
                    "you. You are calm and controlled in the reactions, soft-\n" +
                    "tempered and harmonious, patient and prolonging.\n" +
                    "You’re fond of physical comfort.",
    };

    @Override
    public int getCount() {
        return lst_tip.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view==(RelativeLayout)object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View v=layoutInflater.inflate(R.layout.profile,container,false);

        RelativeLayout slide_relative=v.findViewById(R.id.slide_rel);
        slide_Q=v.findViewById(R.id.slide_Q);
        slide_desc=v.findViewById(R.id.slide_desc);

        v1=v.findViewById(R.id.v1);
        v2=v.findViewById(R.id.v2);
        v3=v.findViewById(R.id.v3);
        v4=v.findViewById(R.id.v4);
        v5=v.findViewById(R.id.v5);
        v6=v.findViewById(R.id.v6);
        v7=v.findViewById(R.id.v7);
        v8=v.findViewById(R.id.v8);
        v9=v.findViewById(R.id.v9);
        v10=v.findViewById(R.id.v10);






     /*   if (billingClient.isReady()){
            SkuDetailsParams params=SkuDetailsParams.newBuilder()
                    .setSkusList(Arrays.asList("slide_1.99"))
                    .setType(BillingClient.SkuType.INAPP)
                    .build();

            billingClient.querySkuDetailsAsync(params, new SkuDetailsResponseListener() {
                @Override
                public void onSkuDetailsResponse(BillingResult billingResult, List<SkuDetails> skuDetailsList) {
                    if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                        Toast.makeText(context, "Go on...", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
*/




        if (position==0) {
               v1.setImageResource(R.drawable.peace_back);

               v2.setImageResource(R.drawable.negat_back);
               v3.setImageResource(R.drawable.negat_back);
               v4.setImageResource(R.drawable.negat_back);
               v5.setImageResource(R.drawable.negat_back);
               v6.setImageResource(R.drawable.negat_back);
               v7.setImageResource(R.drawable.negat_back);
               v8.setImageResource(R.drawable.negat_back);
               v9.setImageResource(R.drawable.negat_back);
               v10.setImageResource(R.drawable.negat_back);


               slide_Q.setText(lst_mainQ[0]);
               slide_desc.setText(lst_Desc[0]);





           }else if (position==1){


/*
               BillingFlowParams billingFlowParams=BillingFlowParams.newBuilder()
                       .setSkuDetails(skuDetails.get(position))
                       .build();

               billingClient.launchBillingFlow((Activity) context.getApplicationContext(),billingFlowParams);*/


               v2.setImageResource(R.drawable.peace_back);

               v1.setImageResource(R.drawable.negat_back);
               v3.setImageResource(R.drawable.negat_back);
               v4.setImageResource(R.drawable.negat_back);
               v5.setImageResource(R.drawable.negat_back);
               v6.setImageResource(R.drawable.negat_back);
               v7.setImageResource(R.drawable.negat_back);
               v8.setImageResource(R.drawable.negat_back);
               v9.setImageResource(R.drawable.negat_back);
               v10.setImageResource(R.drawable.negat_back);

               slide_Q.setText(lst_mainQ[1]);
               slide_desc.setText(lst_Desc[1]);
              }else if (position==2){
               v3.setImageResource(R.drawable.peace_back);

               v1.setImageResource(R.drawable.negat_back);
               v2.setImageResource(R.drawable.negat_back);
               v4.setImageResource(R.drawable.negat_back);
               v5.setImageResource(R.drawable.negat_back);
               v6.setImageResource(R.drawable.negat_back);
               v7.setImageResource(R.drawable.negat_back);
               v8.setImageResource(R.drawable.negat_back);
               v9.setImageResource(R.drawable.negat_back);
               v10.setImageResource(R.drawable.negat_back);


               slide_Q.setText(lst_mainQ[2]);
               slide_desc.setText(lst_Desc[2]);
           }else if (position==3){
               v4.setImageResource(R.drawable.peace_back);

               v1.setImageResource(R.drawable.negat_back);
               v2.setImageResource(R.drawable.negat_back);
               v3.setImageResource(R.drawable.negat_back);
               v5.setImageResource(R.drawable.negat_back);
               v6.setImageResource(R.drawable.negat_back);
               v7.setImageResource(R.drawable.negat_back);
               v8.setImageResource(R.drawable.negat_back);
               v9.setImageResource(R.drawable.negat_back);
               v10.setImageResource(R.drawable.negat_back);

               slide_Q.setText(lst_mainQ[position]);
               slide_desc.setText(lst_Desc[position]);
           }else if (position==4){
               v5.setImageResource(R.drawable.peace_back);

               v1.setImageResource(R.drawable.negat_back);
               v2.setImageResource(R.drawable.negat_back);
               v3.setImageResource(R.drawable.negat_back);
               v4.setImageResource(R.drawable.negat_back);
               v6.setImageResource(R.drawable.negat_back);
               v7.setImageResource(R.drawable.negat_back);
               v8.setImageResource(R.drawable.negat_back);
               v9.setImageResource(R.drawable.negat_back);
               v10.setImageResource(R.drawable.negat_back);


               slide_Q.setText(lst_mainQ[position]);
               slide_desc.setText(lst_Desc[position]);
           }else if (position==5){
               v6.setImageResource(R.drawable.peace_back);

               v1.setImageResource(R.drawable.negat_back);
               v2.setImageResource(R.drawable.negat_back);
               v3.setImageResource(R.drawable.negat_back);
               v4.setImageResource(R.drawable.negat_back);
               v5.setImageResource(R.drawable.negat_back);
               v7.setImageResource(R.drawable.negat_back);
               v8.setImageResource(R.drawable.negat_back);
               v9.setImageResource(R.drawable.negat_back);
               v10.setImageResource(R.drawable.negat_back);


               slide_Q.setText(lst_mainQ[position]);
               slide_desc.setText(lst_Desc[position]);
           }else if (position==6){
               v7.setImageResource(R.drawable.peace_back);

               v1.setImageResource(R.drawable.negat_back);
               v2.setImageResource(R.drawable.negat_back);
               v3.setImageResource(R.drawable.negat_back);
               v4.setImageResource(R.drawable.negat_back);
               v6.setImageResource(R.drawable.negat_back);
               v8.setImageResource(R.drawable.negat_back);
               v9.setImageResource(R.drawable.negat_back);
               v10.setImageResource(R.drawable.negat_back);

               slide_Q.setText(lst_mainQ[position]);
               slide_desc.setText(lst_Desc[position]);
           }else if (position==7){
               v8.setImageResource(R.drawable.peace_back);

               v1.setImageResource(R.drawable.negat_back);
               v2.setImageResource(R.drawable.negat_back);
               v3.setImageResource(R.drawable.negat_back);
               v4.setImageResource(R.drawable.negat_back);
               v6.setImageResource(R.drawable.negat_back);
               v7.setImageResource(R.drawable.negat_back);
               v9.setImageResource(R.drawable.negat_back);
               v10.setImageResource(R.drawable.negat_back);


               slide_Q.setText(lst_mainQ[position]);
               slide_desc.setText(lst_Desc[position]);
           }else if (position==8){
               v9.setImageResource(R.drawable.peace_back);

               v1.setImageResource(R.drawable.negat_back);
               v2.setImageResource(R.drawable.negat_back);
               v3.setImageResource(R.drawable.negat_back);
               v4.setImageResource(R.drawable.negat_back);
               v6.setImageResource(R.drawable.negat_back);
               v7.setImageResource(R.drawable.negat_back);
               v8.setImageResource(R.drawable.negat_back);
               v10.setImageResource(R.drawable.negat_back);

               slide_Q.setText(lst_mainQ[position]);
               slide_desc.setText(lst_Desc[position]);
           }else if (position==9){
               v10.setImageResource(R.drawable.peace_back);

               v1.setImageResource(R.drawable.negat_back);
               v2.setImageResource(R.drawable.negat_back);
               v3.setImageResource(R.drawable.negat_back);
               v4.setImageResource(R.drawable.negat_back);
               v6.setImageResource(R.drawable.negat_back);
               v7.setImageResource(R.drawable.negat_back);
               v8.setImageResource(R.drawable.negat_back);
               v9.setImageResource(R.drawable.negat_back);

               slide_Q.setText(lst_mainQ[position]);
               slide_desc.setText(lst_Desc[position]);
           }

        container.addView(v);
        return v;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }



}
