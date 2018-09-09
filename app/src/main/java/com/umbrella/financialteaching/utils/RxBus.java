package com.umbrella.financialteaching.utils;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

/**
 * Created by chenjun on 18/9/9.
 */
public class RxBus {
    private Subject<Object> mBus;

    private RxBus() {
        mBus = PublishSubject.create().toSerialized();
    }

    public static RxBus getDefault() {
        return RxBusHolder.mInstance;
    }

    private static class RxBusHolder {
        private static final RxBus mInstance = new RxBus();
    }

    public void post(Object o) {
        mBus.onNext(o);
    }

    public <T> Observable<T> toObservable(Class<T> eventType) {
        return mBus.ofType(eventType);
    }
}
