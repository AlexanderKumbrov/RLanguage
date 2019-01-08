package com.example.user.rlanguage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class LessonsFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){
        final Context context = new ContextThemeWrapper(getActivity(), R.style.NightMode);
        View v = inflater.inflate(R.layout.lessons_fragment , container ,false);
        return v;
    }

}
