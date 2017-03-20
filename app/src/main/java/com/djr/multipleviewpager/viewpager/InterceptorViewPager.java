package com.djr.multipleviewpager.viewpager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

/**
 * Created by DongJr on 2017/3/20.
 */

public class InterceptorViewPager extends ViewPager {

    private float startX;

    public InterceptorViewPager(Context context) {
        this(context, null);
    }

    public InterceptorViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        float moveX;
        float offsetX;

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                startX = ev.getX();
                getParent().requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = ev.getX();
                offsetX = moveX - startX;
                if (offsetX < 0) {
                    //当滑动最后一个条目时,让父view处理事件
                    if (getCurrentItem() == getAdapter().getCount() - 1) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                } else {
                    //当滑动第一个条目时,让父view处理事件
                    if (getCurrentItem() == 0) {
                        getParent().requestDisallowInterceptTouchEvent(false);
                    } else {
                        getParent().requestDisallowInterceptTouchEvent(true);
                    }
                }

                Log.e("dispatchTouchEvent","dispatchTouchEvent  "+ offsetX);
                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(ev);
    }
}
