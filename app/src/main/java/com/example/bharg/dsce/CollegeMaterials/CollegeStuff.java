package com.example.bharg.dsce.CollegeMaterials;


import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bharg.dsce.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class CollegeStuff extends Fragment {

private TextView tvtimetable;
private CardView calendar;
    public CollegeStuff() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_college_stuff, container, false);

        tvtimetable = (TextView)view.findViewById(R.id.tvtimetable);
        Typeface roboto = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/Roboto-Medium.ttf"); //use this.getAssets if you are calling from an Activity
        tvtimetable.setTypeface(roboto);

        calendar = (CardView)view.findViewById(R.id.calendarcard);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), ImageViewer.class));
            }
        });
        return view;
    }

}
