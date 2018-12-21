package com.example.user.rlanguage;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class LessonsListFragment extends Fragment {

    private RecyclerView mLessonRecycleView;
    private LessonAdapter mAdapter;
    //Подключение макета lessons_list_fragment
    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.lessons_list_fragment ,container , false);
        mLessonRecycleView = (RecyclerView)view.findViewById(R.id.lesson_recycle_view);
        mLessonRecycleView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        return view;
    }
    //////

    private void updateUI(){
        LessonLab lessonLab = LessonLab.get(getActivity());
        List<Lesson> lesson = lessonLab.getLesson();
        mAdapter = new LessonAdapter(lesson);
        mLessonRecycleView.setAdapter(mAdapter);

    }

    private class LessonHolder extends RecyclerView.ViewHolder{
        public TextView mTitleTextView;
        public LessonHolder (View itemView){
            super(itemView);
            mTitleTextView = (TextView)itemView;        //Заголовок
        }
    }


    //
    private class LessonAdapter extends RecyclerView.Adapter<LessonHolder>{
        private List <Lesson> mLesson;
        public LessonAdapter (List <Lesson> lesson){
            mLesson = lesson;
        }

//Метод вызывается по требованию RecyclerView когда нужно новое представление
        @Override
        public LessonHolder onCreateViewHolder (ViewGroup parent ,int viewType){
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_1 , parent , false);
            return new LessonHolder(view);
        }

        //Метод onBindViewHolder получает данные для обновления view
        @Override
        public void onBindViewHolder(LessonHolder holder , int position){
            Lesson lesson = mLesson.get(position);
            holder.mTitleTextView.setText(lesson.getTitleLess());
        }


        @Override
        public int getItemCount(){
            return  mLesson.size();
        }
    }
}
