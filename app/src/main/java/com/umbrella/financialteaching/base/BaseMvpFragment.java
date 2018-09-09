package com.umbrella.financialteaching.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

/**
 * Created by chenjun on 18/9/9.
 */

public abstract class BaseMvpFragment<P extends BasePresenter> extends BaseFragment {
    protected P mMvpPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mMvpPresenter = createPresenter();
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mMvpPresenter != null) {
            mMvpPresenter.detachView();
            mMvpPresenter = null;
        }
    }

    @Override
    protected void lazyLoad() {
        if (mMvpPresenter == null) {
            mMvpPresenter = createPresenter();
        }
        super.lazyLoad();
    }

    protected abstract P createPresenter();
}
