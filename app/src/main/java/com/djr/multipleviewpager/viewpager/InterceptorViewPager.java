package com.djr.multipleviewpager.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by DongJr on 2017/3/20.
 */

public class InterceptorViewPager extends ViewPager {


    public InterceptorViewPager(Context context) {
        this(context, null);
    }

    public InterceptorViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e("dong", "onInterceptTouchEvent");

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        Log.e("dong", "onTouchEvent");


        return super.onTouchEvent(ev);
    }


    @Override
    protected boolean canScroll(View v, boolean checkV, int dx, int x, int y) {
        if (v != this && v instanceof ViewPager) {
            int currentItem = ((ViewPager) v).getCurrentItem();
            int countItem = ((ViewPager) v).getAdapter().getCount();
            if ((currentItem == (countItem - 1) && dx < 0) || (currentItem == 0 && dx > 0)) {
                Log.e("dong", "canScroll perform");
                return false;
            }
            return true;
        }
        return super.canScroll(v, checkV, dx, x, y);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e("dong", "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
    }


}
