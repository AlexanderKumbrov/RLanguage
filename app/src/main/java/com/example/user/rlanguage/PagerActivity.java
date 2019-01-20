package com.example.user.rlanguage;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentActivity;
        import android.support.v4.view.ViewPager;
        import android.view.MotionEvent;


public class PagerActivity extends FragmentActivity {
    ViewPager viewPager;
    SaveNightMod saveNightMod;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        saveNightMod = new SaveNightMod(this);
        if (saveNightMod.loadNightModState()==true){
            setTheme(R.style.NightMode);
        }
        else
            setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.lessons_pager_activity);
        viewPager = (ViewPager) findViewById(R.id.activity_view_pager_lessons);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        saveNightMod = new SaveNightMod(this);


    }
}
