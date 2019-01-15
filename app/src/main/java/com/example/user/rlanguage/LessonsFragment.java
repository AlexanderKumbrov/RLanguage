package com.example.user.rlanguage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

public class LessonsFragment extends Fragment {
    SaveNightMod saveNightMod;
    Lesson lesson;
    TextView titleLessons;
    private final static String ARG_LESSONS_ID ="lesson_id";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        UUID lessonID = (UUID)getArguments().getSerializable(ARG_LESSONS_ID);

    }

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){
        saveNightMod = new SaveNightMod(getActivity());
        if (saveNightMod.loadNightModState()==true){
            final Context context = new ContextThemeWrapper(getContext(), R.style.NightMode);
            LayoutInflater localInflater = inflater.cloneInContext(context);
            return localInflater.inflate(R.layout.lessons_fragment , container , false);

        }
        else {
            final Context context = new ContextThemeWrapper(getContext(), R.style.AppTheme);
            LayoutInflater localInflater = inflater.cloneInContext(context);
            return localInflater.inflate(R.layout.lessons_fragment , container , false);

        }
    }
}
