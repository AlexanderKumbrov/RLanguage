package com.example.user.rlanguage;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private LayoutInflater layoutInflater;
    private int[] ipsumLor = {R.string.lorem1 , R.string.lorem2 , R.string.lorem3};
    Lesson lesson = new Lesson();
    public ViewPagerAdapter(Context context) {

          this.context = context;
    }

    @Override
    public int getCount() {
        return ipsumLor.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.lessons_fragment,null);
        TextView textView = (TextView)view.findViewById(R.id.lesson_ipsum_id);
        textView.setText(ipsumLor[position]);
        ViewPager vp = (ViewPager) container;
        vp.addView(view ,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager vp = (ViewPager)container;
        View view = (View)object;
        vp.removeView(view);
    }
}
