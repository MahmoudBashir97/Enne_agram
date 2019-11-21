package com.example.enneadram.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingClientStateListener;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesUpdatedListener;
import com.android.billingclient.api.SkuDetails;
import com.android.billingclient.api.SkuDetailsParams;
import com.android.billingclient.api.SkuDetailsResponseListener;
import com.example.enneadram.Adapters.profile_pager_adpt;
import com.example.enneadram.Billing.Billing_inapp;
import com.example.enneadram.R;
import com.example.enneadram.ui.Crush_types;

import java.util.Arrays;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {

    View v;
    private ViewPager prof_pager;
    private profile_pager_adpt pager_adpt;
    private ImageView next_btn;
    private int counter=-1;
    private ImageView img_type ,v1,v2,v3,v4,v5,v6,v7,v8,v9,v10,v11,v12,v13,v14,v15,v16,v17,v18,v19,v20,v21,v22,v23,v24;
    private ImageButton share_btn;

     TextView side_type_text,txt_desc,slide_type,txt_type;
     int cruchT_1,cruchT_2,cruchT_3;
     String type;

     BillingClient billingClient;
    public ProfileFragment(String type) {
        // Required empty public constructor
        this.type=type;
    }
    public String[] lst_Desc_types={
            "You are a serious, prince some, idealistic, rational, and a perfectionist.\n" +
                    "You do a job in full and in accordance, you are serious, sensible and controlling, responsive in responsibilities,\n" +
                    "You are regular and rigorous, self-disciplined, restrained, and idealistic.\n",
            "You're romantic, caring, friendly, talkative, and easy-to-communicate.\n" +
                    "You show your feelings; you are helpful, generous,\n" +
                    "compassionate, friendly, caring, and warm. You care about love and give importance to relationships.\n" +
                    "You're friendly and supportive.\n",
            "You, who love to admire your personality and effectiveness, who likes to be successful and impressive,\n" +
                    "you’re hesitant, business-oriented, pragmatic, and highly motivated. You give importance to your status.\n" +
                    "You're competitive and confident.\n",
            "Your emotional side is stronger, but you don’t reveal your feelings that are romantic, sensitive, caring, and honest.\n" +
                    "You are intuitive and have deep insight, looking for meaning and depth. You are authentic, gentle, delicate, individuality-loving, aesthetic, and, strong. You're honest with yourself.\n",
            "You are a rational, curious, and abstract thinker with looking in depth of the information.\n" +
                    "You're usually introvert, not disturbed by being alone.\n" +
                    "Deeply curious and specialized, logical and analytical, self-sufficient, well-observed and genuinely minded, knowledge-loving, relentless, and objective.\n",
            "You need to feel confident and safe.\n" +
                    "You're a cautious, curious, and interrogative! Trust and safety are an essential part of your personality.\n" +
                    "You are questioning and controlling all the possibilities, sensitive to mutual responsibilities, and wondering the details. You are susceptible to errors and inconsistencies.\n",
            "You're an optimistic, unfit, emotionally-incompetent person who likes to explore and experience new things.\n" +
                    "You are curious and you mental associations are intense.\n" +
                    "You are focused, fun and cheerful, spontaneous and fast, engaged and talkative, not worn to the past and the pain,\n" +
                    "You concentrate on practical thinking and solution.\n",
            "You are brave, decisive, confident, and authoritarian.\n" +
                    "You're the one who cares about being strong and independent. You are bold and confident, straightforward and stable, strong and durable, and intervening. You’re strict and dominant, competitive, and authoritarian.\n",
            "Your patience, which prioritizes peace and reconciliation, seeks harmony and peace. You're a man who avoids conflict and tension. Peace and tranquility presuppose you. You are calm and controlled in the reactions, soft-tempered and harmonious, patient and prolonging. You're fond of physical comfort."
    };

    public String[] lst_partDesc_belowType={
            "",
            "Also, you are a serious, prince some, idealistic, rational, and a perfectionist.",
            "Also, you are romantic, caring, friendly, talkative, and easy-to-communicate.",
            "Also, you are hesitant, business-oriented, pragmatic, and highly motivated.\n You give importance to your status.",
            "Also, you are intuitive and have deep insight, looking for meaning and depth.\n You are authentic, gentle, delicate, individuality-loving, aesthetic, and, strong.",
            "Also, you are a rational, curious, and abstract thinker with looking in depth of the information.",
            "Also, you are questioning and controlling all the possibilities, sensitive to mutual responsibilities, and wondering the details.\n You are susceptible to errors and inconsistencies.",
            "Also, you are an optimistic, unfit, emotionally-incompetent person who likes to explore and experience new things.",
            "Also, you are the one who cares about being strong and independent.\n You are bold and confident, straightforward and stable, strong and durable, and intervening.",
            "Also, you are a man who avoids conflict and tension. Peace and tranquility presuppose you.\n You are calm and controlled in the reactions, soft-tempered and harmonious, patient and prolonging."
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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_profile, container, false);

        txt_type=v.findViewById(R.id.txt_type);
        img_type=v.findViewById(R.id.img_type);

        prof_pager=v.findViewById(R.id.profile_pag);
        next_btn=v.findViewById(R.id.next_btn);
        slide_type=v.findViewById(R.id.slide_type);
        txt_desc=v.findViewById(R.id.txt_desc);
        side_type_text=v.findViewById(R.id.side_type_text);
        share_btn=v.findViewById(R.id.share_btn);


        //to share this app with friends with link google play
        share_btn.setOnClickListener(view -> {
            Intent sendIntent = new Intent(Intent.ACTION_SEND);
            sendIntent.setType("text/plain");
            sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My App Name");
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Share this App with");
            startActivity(Intent.createChooser(sendIntent, "Share app via"));
        });
        //setupBillingClient();

        Kind_type();

        Questions_view();


        pager_adpt=new profile_pager_adpt(getContext());
        prof_pager.setAdapter(pager_adpt);
        return v;
    }

    private void Questions_view(){
       next_btn.setOnClickListener(view -> {

           Billing_inapp billing_inapp=new Billing_inapp();
           billing_inapp.setupBilling("slide_1.99", getContext());
           Intent intent=new Intent(getContext(), Crush_types.class);
           intent.putExtra("C1",""+cruchT_1);
           intent.putExtra("C2",""+cruchT_2);
           intent.putExtra("C3",""+cruchT_3);
           startActivity(intent);

       });

    }

    public void Kind_type(){
              if (type.equals("Type-1")){
                  txt_type.setText("Type 1");
                  img_type.setImageResource(lst_tip[0]);
                  txt_desc.setText(lst_Desc_types[0]);
                  slide_type.setText("Side Type 2");
                  side_type_text.setText(lst_partDesc_belowType[2]);
                  cruchT_1=2;
                  cruchT_2=3;
                  cruchT_3=4;
        }else if (type.equals("Type-2")){
                  txt_type.setText("Type 2");
                  img_type.setImageResource(lst_tip[1]);
                  txt_desc.setText(lst_Desc_types[1]);
                  slide_type.setText("Side Type 3");
                  side_type_text.setText(lst_partDesc_belowType[3]);
                  cruchT_1=3;
                  cruchT_2=5;
                  cruchT_3=7;
        }else if (type.equals("Type-3")){
                  txt_type.setText("Type 3");
                  img_type.setImageResource(lst_tip[2]);
                  txt_desc.setText(lst_Desc_types[2]);
                  slide_type.setText("Side Type 5");
                  side_type_text.setText(lst_partDesc_belowType[5]);
                  cruchT_1=4;
                  cruchT_2=6;
                  cruchT_3=9;
        }else if (type.equals("Type-4")){
                  txt_type.setText("Type 4");
                  img_type.setImageResource(lst_tip[3]);
                  txt_desc.setText(lst_Desc_types[3]);
                  slide_type.setText("Side Type 9");
                  side_type_text.setText(lst_partDesc_belowType[9]);
                  cruchT_1=1;
                  cruchT_2=8;
                  cruchT_3=9;
        }else if (type.equals("Type-5")){
                  txt_type.setText("Type 5");
                  img_type.setImageResource(lst_tip[4]);
                  txt_desc.setText(lst_Desc_types[4]);
                  slide_type.setText("Side Type 6");
                  side_type_text.setText(lst_partDesc_belowType[6]);
                  cruchT_1=2;
                  cruchT_2=4;
                  cruchT_3=5;
        }else if (type.equals("Type-6")){
                  txt_type.setText("Type 6");
                  img_type.setImageResource(lst_tip[5]);
                  txt_desc.setText(lst_Desc_types[5]);
                  slide_type.setText("Side Type 7");
                  side_type_text.setText(lst_partDesc_belowType[7]);
                  cruchT_1=4;
                  cruchT_2=6;
                  cruchT_3=8;
        }else if (type.equals("Type-7")){
                  txt_type.setText("Type 7");
                  img_type.setImageResource(lst_tip[6]);
                  txt_desc.setText(lst_Desc_types[6]);
                  slide_type.setText("Side Type 8");
                  side_type_text.setText(lst_partDesc_belowType[8]);
                  cruchT_1=1;
                  cruchT_2=3;
                  cruchT_3=4;
        }else if (type.equals("Type-8")){
                  txt_type.setText("Type 8");
                  img_type.setImageResource(lst_tip[7]);
                  txt_desc.setText(lst_Desc_types[7]);
                  slide_type.setText("Side Type 1");
                  side_type_text.setText(lst_partDesc_belowType[1]);
                  cruchT_1=5;
                  cruchT_2=6;
                  cruchT_3=8;
        }
    }

   /* private void setupBillingClient(){
        billingClient=BillingClient.newBuilder(this).setListener(this).build();
        billingClient.startConnection(new BillingClientStateListener() {
            @Override
            public void onBillingSetupFinished(BillingResult billingResult) {
                if (billingResult.getResponseCode() == BillingClient.BillingResponseCode.OK) {
                    // The BillingClient is ready. You can query purchases here.

                    Toast.makeText(getContext(), "Success to connect Billing", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getContext(), ""+billingResult.getResponseCode(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onBillingServiceDisconnected() {

                Toast.makeText(getContext(), "You are disconnect from Billing", Toast.LENGTH_SHORT).show();


            }
        });

    }

    @Override
    public void onPurchasesUpdated(BillingResult billingResult, @Nullable List<Purchase> purchases) {
        Toast.makeText(getContext(), "purchase item : "+purchases.size(), Toast.LENGTH_SHORT).show();

    }*/
}
