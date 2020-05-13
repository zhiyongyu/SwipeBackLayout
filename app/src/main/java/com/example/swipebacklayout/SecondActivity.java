package com.example.swipebacklayout;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.lib.common.SwipeBackActivity;

public class SecondActivity extends SwipeBackActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }
}
