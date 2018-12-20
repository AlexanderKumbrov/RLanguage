package com.example.user.rlanguage;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LessonLab {
    private static LessonLab lessonLab;
    private List<Lesson> mLesson;

    private static LessonLab get(Context context){
        if (lessonLab == null){
            lessonLab = new LessonLab(context);
        }
        return lessonLab;
    }
    private LessonLab(Context context){
mLesson = new ArrayList<>();

for (int i =0 ; i <20 ; i++){
    Lesson lesson =  new Lesson();
    lesson.setTitleLess("Lesson # "+i);
    mLesson.add(lesson);
}
    }

    public List<Lesson>getLesson(){
        return mLesson;
    }

    public Lesson getLeson(UUID idLess){
        for (Lesson lesson : mLesson){
            if (lesson.getIdLess().equals(idLess)){
                return lesson;
            }
        }
        return null;
    }

}
