package com.umbrella.financialteaching.base;

/**
 * Created by chenjun on 18/9/9.
 */

public interface Presenter<V> {
    void attachView(V view);

    void detachView();
}
