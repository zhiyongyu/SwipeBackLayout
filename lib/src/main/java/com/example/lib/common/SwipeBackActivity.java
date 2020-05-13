package com.example.lib.common;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.lib.utils.Utils;
import com.example.lib.view.SwipeBackLayout;

public class SwipeBackActivity extends Activity implements SwipeBackActivityBase{

    private SwipeBackActivityHelper mHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mHelper = new SwipeBackActivityHelper(this);
        mHelper.onActivityCreate();
    }

    /**
     * 此方法。是onCreate完成后的回调。
     * 表示Activity已经跑起来了
     */
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mHelper.onPostCreate();
    }

    /**
     * 重写findViewById方法，目测估计是留给外部获取SwipeBackLayout用的。
     * @param id
     * @return
     */
    @Override
    public <T extends View> T findViewById(int id) {
        View view = super.findViewById(id);
        if(view == null && mHelper != null){
            return (T) mHelper.findViewById(id);
        }
        return (T) view;
    }

    @Override
    public SwipeBackLayout getSwipeBackLayout() {
        return mHelper.getSwipeBackLayout();
    }

    @Override
    public void setSwipeBackEnable(boolean enable) {
        getSwipeBackLayout().setEnableGesture(enable);
    }

    @Override
    public void scrollToFinishActivity() {
        Utils.convertActivityToTranslucent(this);
        getSwipeBackLayout().scrollToFinishActivity();
    }
}
