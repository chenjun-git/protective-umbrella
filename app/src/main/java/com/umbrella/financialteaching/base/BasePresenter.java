package com.umbrella.financialteaching.base;

import com.umbrella.financialteaching.model.Notice;
import com.umbrella.financialteaching.utils.RxBus;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by chenjun on 18/9/9.
 */

public class BasePresenter<V> implements Presenter<V> {

    public V mMvpView;
    private CompositeDisposable mCompositeDisposable;

    public BasePresenter(V mvpView) {
        attachView(mvpView);
    }

    @Override
    public void attachView(V mvpView) {
        this.mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        this.mMvpView = null;
        onUnsubscribe();
    }

    public void onUnsubscribe() {
        if (mCompositeDisposable != null && mCompositeDisposable.isDisposed()) {
            mCompositeDisposable.dispose();
        }
    }

    public void post(Notice msg) {
        RxBus.getDefault().post(msg);
    }

    public void addSubscription(Observable observable, BaseObserver observer) {
        if (mCompositeDisposable == null) {
            mCompositeDisposable = new CompositeDisposable();
        }

        BaseObserver baseObserver = (BaseObserver) observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(observer);
        mCompositeDisposable.add(baseObserver.getDisposable());
    }
}
