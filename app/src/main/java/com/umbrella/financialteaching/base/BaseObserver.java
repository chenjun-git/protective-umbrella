package com.umbrella.financialteaching.base;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by chenjun on 18/9/9.
 */

public abstract class BaseObserver implements Observer{
    private Disposable mDisposable;

    public Disposable getDisposable() {
        return mDisposable;
    }

    @Override
    public void onSubscribe(Disposable d) {
        mDisposable = d;
    }
}
