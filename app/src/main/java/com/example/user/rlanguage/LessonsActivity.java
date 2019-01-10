package com.example.user.rlanguage;

import android.support.v4.app.Fragment;

public class LessonsActivity extends SingleCreateFragment {
    @Override
    protected Fragment createFragment(){
        return new LessonsFragment();
    }
}
