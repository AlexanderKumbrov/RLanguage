package com.example.user.rlanguage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import java.util.List;
import java.util.UUID;

public class PagerActivity extends FragmentActivity {
    private final static String EXTRA_ID_LESSON ="com.example.user.rlanguage.lesson_id";
    private ViewPager mViewpager;
    private List <Lesson> mLesson;
    public static Intent newIstance(Context packageContext , UUID lessonId){
        Intent intent = new Intent(packageContext , PagerActivity.class);
        intent.putExtra(EXTRA_ID_LESSON , lessonId);
        return intent;
    }
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lessons_pager_activity);
        UUID lessonId = (UUID)getIntent().getSerializableExtra(EXTRA_ID_LESSON);

        mViewpager = (ViewPager)findViewById(R.id.activity_view_pager_lessons);
        mLesson = LessonLab.get(this).getLesson();
        FragmentManager fragmentManager = getSupportFragmentManager();
        mViewpager.setAdapter(new FragmentStatePagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                Lesson lesson = mLesson.get(position);
                return LessonsFragment.newInstance(lesson.getIdLess());
            }
            @Override
            public int getCount() {
                return mLesson.size();
            }
        });
    }
}
