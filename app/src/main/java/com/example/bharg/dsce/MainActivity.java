package com.example.bharg.dsce;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.bharg.dsce.Authentication.LoginActivity;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private TabLayout tabs;
    private ViewPager viewPager;
    private HomeScreenAdapter homescreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() ==null)
                {
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                }
            }
        };

        tabs = (TabLayout)findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("announce"));
        tabs.addTab(tabs.newTab().setText("collegestuff"));
        tabs.addTab(tabs.newTab().setText("user"));
        tabs.setTabGravity(tabs.GRAVITY_FILL);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
        homescreen = new HomeScreenAdapter(getSupportFragmentManager(),tabs.getTabCount());
        viewPager.setAdapter(homescreen);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabs));
        tabs.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    }
}
