package com.example.user.rlanguage;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class LessonsListFragment extends Fragment {

    private RecyclerView mLessonRecycleView;
    private LessonAdapter mAdapter;

    //Подключение макета lessons_list_fragment

    @Override
    public View onCreateView(LayoutInflater inflater , ViewGroup container , Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.lessons_list_fragment ,container , false);

        mLessonRecycleView = (RecyclerView)view.findViewById(R.id.lesson_recycle_view);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
        mLessonRecycleView.addItemDecoration(new GridItemDecoration(2 , dpToPx(20),true));
        mLessonRecycleView.setLayoutManager(layoutManager);
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

    private class LessonHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView mTitleTextView;
        private Lesson mLesson;

        public LessonHolder (View itemView){
            super(itemView);
            itemView.setOnClickListener(this);
            mTitleTextView = (TextView)itemView.findViewById(R.id.less_title);       //Заголовок

        }

        public void bindLesson (Lesson lesson){
            mLesson = lesson;
            mTitleTextView.setText(mLesson.getTitleLess());

        }
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity() , PagerActivity.class);
            startActivity(intent);
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
            View view = layoutInflater.inflate(R.layout.item_list_lessons, parent , false);
            return new LessonHolder(view);
        }

        //Метод onBindViewHolder получает данные для обновления view
        @Override
        public void onBindViewHolder(LessonHolder holder , int position){
            Lesson lesson = mLesson.get(position);
            holder.bindLesson(lesson);

        }


        @Override
        public int getItemCount(){
            return  mLesson.size();
        }
    }

    //Изменение элементов recycler view
    public class GridItemDecoration extends RecyclerView.ItemDecoration{
        private int spanCount;
        private int spacing ;
        private boolean includeEdge;
        public GridItemDecoration (int spanCount , int spacing , boolean includeEdge){
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }
        @Override
        public  void  getItemOffsets (Rect outRect , View view , RecyclerView parent , RecyclerView.State state){
            int position = parent.getChildAdapterPosition(view);
            int column = position % spanCount ;
            if (includeEdge){
                outRect.left = spacing - column * spacing / spanCount ;
                outRect.right= (column +1 ) * spacing / spanCount ;
                if (position < spanCount){
                    outRect.top = spacing ;
                }
                outRect.bottom = spacing ;
            }
            else {
                outRect.left = column * spacing / spanCount ;
                outRect.right = spacing - (column + 1) * spacing / spanCount ;
                if (position >= spanCount){
                    outRect.top = spacing ;
                }
            }
        }
    }
    private  int dpToPx (int dp ){
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP , dp ,r.getDisplayMetrics()));
    }
}
