package com.umbrella.financialteaching.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by chenjun on 18/9/9.
 */

public abstract class BaseMvpActivity <P extends BasePresenter> extends BaseActivity {
    protected P mMvpPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMvpPresenter = createPresenter();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mMvpPresenter != null) {
            mMvpPresenter.detachView();
        }
    }

    protected abstract P createPresenter();
}
