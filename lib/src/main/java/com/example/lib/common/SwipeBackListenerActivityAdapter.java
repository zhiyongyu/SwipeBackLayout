package com.example.lib.common;

import android.app.Activity;

import com.example.lib.utils.Utils;
import com.example.lib.view.SwipeBackLayout;

import java.lang.ref.WeakReference;

public class SwipeBackListenerActivityAdapter implements SwipeBackLayout.SwipeListenerEx {

    private final WeakReference<Activity> mActivity;

    public SwipeBackListenerActivityAdapter(Activity mActivity) {
        this.mActivity = new WeakReference<Activity>(mActivity);
    }

    @Override
    public void onScrollStateChange(int state, float scrollPercent) {

    }

    @Override
    public void onEdgeTouch(int edgeFlag) {
        Activity activity = mActivity.get();
        if (null != activity) {
            Utils.convertActivityToTranslucent(activity);
        }
    }

    @Override
    public void onScrollOverThreshold() {

    }

    @Override
    public void onContentViewSwipedBack() {
        Activity activity = mActivity.get();
        if (null != activity && !activity.isFinishing()) {
            activity.finish();
            activity.overridePendingTransition(0, 0);
        }
    }
}
