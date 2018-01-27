package com.example.bharg.dsce;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by bharg on 25-01-2018.
 */

public class HomeScreenAdapter extends FragmentPagerAdapter {
    int nmTabs;
    public HomeScreenAdapter(FragmentManager fm ,int Numtabs) {
        super(fm);
        this.nmTabs = Numtabs;
    }
    @Override
    public Fragment getItem(int position) {
            switch(position){
                case 0:
                    NewsAndAnncouncement news = new NewsAndAnncouncement();
                    return  news;
                case 1:
                    CollegeStuff col = new CollegeStuff();
                    return col;
                case 2:
                    UserFragment user = new UserFragment();
                    return user;
                default: return null;
            }
    }

    @Override
    public int getCount() {
        return nmTabs;
    }
}
