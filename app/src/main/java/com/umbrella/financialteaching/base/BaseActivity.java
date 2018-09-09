package com.umbrella.financialteaching.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.logging.Logger;

import me.imid.swipebacklayout.lib.SwipeBackLayout;

/**
 * Created by chenjun on 18/9/9.
 */

public  abstract class BaseActivity extends AppCompatActivity{
    protected Context mContext;
    private SwipeBackLayout mSwipeBackLayout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mContext = this;

        initView(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        View view = LayoutInflater.from(this).inflate(layoutResID, null);
        mSwipeBackLayout.addView(view);
    }

    private View getContrainer() {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        mSwipeBackLayout = new SwipeBackLayout(this);
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
        relativeLayout.addView(mSwipeBackLayout);
        return getContrainer();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    protected void initView(Bundle saveInstanceState) {
        loadViewLayout();
        bindViews();
        processLogic(saveInstanceState);
        setListener();
    }

    protected void showLog(String log) {
    }

    protected abstract void loadViewLayout();

    protected abstract void bindViews();

    protected abstract void processLogic(Bundle saveInstanceState);

    protected abstract void setListener();

    protected void intent2Activity(Class<? extends Activity> targetActivity) {
        Intent intent = new Intent(mContext, targetActivity);
        startActivity(intent);
    }

}
