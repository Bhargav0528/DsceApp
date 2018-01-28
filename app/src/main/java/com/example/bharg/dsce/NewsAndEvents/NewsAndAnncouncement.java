package com.example.bharg.dsce.NewsAndEvents;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bharg.dsce.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsAndAnncouncement extends Fragment {

    private TabLayout tabs1;
    private ViewPager viewPager;
    private AnnouncementAdapter announce;

    public NewsAndAnncouncement() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news_and_anncouncement, container, false);

        tabs1 = (TabLayout)view.findViewById(R.id.tabs1);
        tabs1.addTab(tabs1.newTab().setText("News"));
        tabs1.addTab(tabs1.newTab().setText("Events"));
        tabs1.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        announce  = new AnnouncementAdapter(getChildFragmentManager(),tabs1.getTabCount());
        viewPager.setAdapter(announce);


        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs1));
        tabs1.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return view;
    }

}
