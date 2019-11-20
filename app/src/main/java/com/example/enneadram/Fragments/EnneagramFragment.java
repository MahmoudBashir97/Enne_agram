package com.example.enneadram.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.enneadram.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EnneagramFragment extends Fragment {

    View v;
    TextView Enn_define;
    public EnneagramFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v= inflater.inflate(R.layout.fragment_enneagram, container, false);
       Enn_define=v.findViewById(R.id.Enn_define);
       String define="Enneagram is a powerful and dynamic personality model that defines the person's emotion and style of action. When you discover your personality type and the key features belonging to this structure, you'll see what motivates you, the aspects of your focus, your strategy to cope with problems, and the points you need to consider for yourself to develop. \n \n In detail, every human being is different from another person, but there are basically 9 different personality types. Each person carries one of these 9 personality types predominantly. This is the person's main personality type. In addition, there are some personality traits that are carried on the secondary level. This is called the side personality type.";

       Enn_define.setText(define);
        return v;
    }

}
