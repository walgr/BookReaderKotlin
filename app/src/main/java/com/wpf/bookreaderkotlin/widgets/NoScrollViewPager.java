package com.wpf.bookreaderkotlin.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

/**
 * Created by wpf on 12-18-0018.
 * 不可滑动的ViewPager
 */

public class NoScrollViewPager extends ViewPager {

    private boolean isScrollable;

    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return isScrollable && super.onTouchEvent(ev);

    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return isScrollable && super.onInterceptTouchEvent(ev);

    }

    public NoScrollViewPager setScrollable(boolean isScrollable) {
        this.isScrollable = isScrollable;
        return this;
    }
}
