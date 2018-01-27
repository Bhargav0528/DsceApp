package com.example.bharg.dsce;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by bharg on 25-01-2018.
 */

public class AnnouncementAdapter extends FragmentPagerAdapter {

    int numtabs;

    public AnnouncementAdapter (FragmentManager fm,int numbertab){
        super(fm);
        this.numtabs = numbertab;
    }
    @Override
    public Fragment getItem(int position) {
        switch(position)
        {
            case 0:
                News news = new News();
                return news;
            case 1:
                Events eve = new Events();
                return eve;
            default:return null;
        }
    }

    @Override
    public int getCount() {
        return numtabs;
    }
}
