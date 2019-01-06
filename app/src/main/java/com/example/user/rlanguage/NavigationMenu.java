package com.example.user.rlanguage;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class NavigationMenu extends AppCompatActivity {
    LessonsListFragment lessonsListFragment = new LessonsListFragment() ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_menu);
        loadFragment(lessonsListFragment);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams)navigation.getLayoutParams();
        layoutParams.setBehavior(new NavigationMenuHidden());


    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_lessons:
                    fragment = (lessonsListFragment);
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_bookmark:
                    return true;
                case R.id.navigation_settings:
                    return true;
            }
            return false;
        }
    };
    private void loadFragment (Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container , fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}