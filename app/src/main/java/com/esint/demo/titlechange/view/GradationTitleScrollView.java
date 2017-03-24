package com.esint.demo.titlechange.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;


/**
 * Created by Linsa on 2017/3/24:11:04.
 * des:
 */

public class GradationTitleScrollView extends ScrollView {

    public ScrollViewListener listener=null;

    public GradationTitleScrollView(Context context) {
        this(context,null);
    }

    public GradationTitleScrollView(Context context, AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public GradationTitleScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    /**
     * @param l  Current horizontal scroll origin.
     * @param t  Current vertical scroll origin.
     * @param oldl   Previous horizontal scroll origin.
     * @param oldt   Previous vertical scroll origin.
     */
    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (listener!=null){
            listener.onScrollChanged(this,l,t,oldl,oldt);
        }
    }


    /**
     * 设置ScrollView滑动监听
     */
    public interface ScrollViewListener{
        void onScrollChanged(GradationTitleScrollView scrollView, int x, int y,
                             int oldx, int oldy);
    }


    /** 设置监听的方法 */
    public void setOnScrollViewListener(ScrollViewListener listener){
        this.listener=listener;
    }
}
