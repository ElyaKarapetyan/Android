package com.example.app.taskapp;


import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.view.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SliderActivity extends AppCompatActivity {

    private int[] layoutList = {R.layout.first_slide, R.layout.second_slide, R.layout.third_slide};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        ViewPager mViewPager = findViewById(R.id.container);

        AdapterForSlide adapter = new AdapterForSlide(layoutList, this);
        mViewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);

        final Button skipBtn = findViewById(R.id.skip_button);
        skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goLoginPage();
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == layoutList.length - 1) {
                    skipBtn.setText("Start");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void goLoginPage() {
        startActivity(new Intent(this, LoginAndRegistrationActivity.class ));
    }
}
