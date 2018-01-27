package com.example.bharg.dsce.Authentication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.bharg.dsce.Authentication.Fragments.SignInFragment;
import com.example.bharg.dsce.Authentication.Fragments.SignUpFragment;

/**
 * Created by bharg on 23-01-2018.
 */

public class LoginPageAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public LoginPageAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SignInFragment tab1 = new SignInFragment();
                return tab1;
            case 1:
                SignUpFragment tab2 = new SignUpFragment();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}