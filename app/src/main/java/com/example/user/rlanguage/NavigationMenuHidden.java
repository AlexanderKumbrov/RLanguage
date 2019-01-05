package com.example.user.rlanguage;

import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.widget.FrameLayout;

public class NavigationMenuHidden extends CoordinatorLayout.Behavior<BottomNavigationView> {
    public NavigationMenuHidden () {
        super();
    }

    @Override
    public boolean layoutDependsOn (CoordinatorLayout parent , BottomNavigationView child , View dependency){
        boolean dependOn  = dependency instanceof FrameLayout;
        return dependOn;
    }
    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomNavigationView child, View directTargetChild, View target, int nestedScroll) {
        return nestedScroll == ViewCompat.SCROLL_AXIS_VERTICAL;
    }
    @Override
    public void onNestedPreScroll (CoordinatorLayout coordinatorLayout , BottomNavigationView child , View target , int dx , int dy , int []consumed){
if (dy < 0){
    showBottomNavigationView(child);
}
else if (dy > 0){
    hideBottomNavigationView(child);
}
}
private void hideBottomNavigationView(BottomNavigationView view){
        view.animate().translationY(view.getHeight());
}
private void showBottomNavigationView(BottomNavigationView view){
        view.animate().translationY(0);
}
}
