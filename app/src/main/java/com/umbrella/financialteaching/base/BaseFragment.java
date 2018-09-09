package com.umbrella.financialteaching.base;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.umbrella.financialteaching.model.Notice;
import com.umbrella.financialteaching.utils.RxBus;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

/**
 * Created by chenjun on 18/9/9.
 */

public abstract class BaseFragment extends Fragment{
    protected Activity mContext;
    protected boolean mIsFirstVisiable = true;
    protected View mRootView;
    protected Disposable mDisposable;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return loadViewLayout(inflater, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mContext = getActivity();
        mRootView = view;
        initView(mRootView);
        boolean isVisable = isHidden() || getUserVisibleHint();
        if (isVisable && mIsFirstVisiable) {
            lazyLoad();
            mIsFirstVisiable = false;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mDisposable != null) {
            mDisposable.dispose();
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            onVisiable();
        } else {
            onInVisiable();
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            onVisiable();
        } else {
            onInVisiable();
        }
    }

    protected void intent2Activity(Class<? extends Activity> targetActivity) {
        Intent intent = new Intent(mContext, targetActivity);
        startActivity(intent);
    }

    protected void onVisiable() {
        if (mIsFirstVisiable && isResumed()) {
            lazyLoad();
            mIsFirstVisiable = false;
        }
    }

    protected void onInVisiable() {

    }

    private void initView(View view) {
        bindViews(view);
        processLogic();
        setListener();
    }

    protected void lazyLoad() {

    }

    protected abstract View loadViewLayout(LayoutInflater inflater, ViewGroup container);

    protected abstract void bindViews(View view);

    protected abstract void processLogic();

    protected abstract void setListener();

    protected void showLog() {

    }

    public Observable<Notice> toObservable() {
        return RxBus.getDefault().toObservable(Notice.class);
    }
    public void post(Notice msg) {
        RxBus.getDefault().post(msg);
    }
}
