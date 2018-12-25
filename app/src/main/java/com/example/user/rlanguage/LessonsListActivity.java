package com.example.user.rlanguage;

import android.support.v4.app.Fragment;

public class LessonsListActivity extends SingleCreateFragment {

    @Override
    protected Fragment createFragment(){
        return new LessonsListFragment();
    }
}
