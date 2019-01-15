package com.example.user.rlanguage;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;


public class PagerActivity extends FragmentActivity {
    ViewPager viewPager;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons_pager_activity);
        viewPager = (ViewPager) findViewById(R.id.activity_view_pager_lessons);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
    }
}
