package com.umbrella.financialteaching.base;

import android.os.Handler;
import android.os.Looper;

import com.umbrella.financialteaching.utils.ToastUtil;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

import io.reactivex.subscribers.DefaultSubscriber;

/**
 * Created by chenjun on 18/9/9.
 */

public abstract class BaseCallBack<T> extends DefaultSubscriber<T> {
    private Handler mHandler;

    public BaseCallBack() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public void onComplete() {
        mHandler = null;
    }

    @Override
    public void onError(final Throwable t) {
        t.printStackTrace();
        mHandler.post(new Runnable() {
                          @Override
                          public void run() {
                              if (t instanceof SocketTimeoutException) {
                                  ToastUtil.showToast("网络连接超时");
                              } else if (t instanceof SocketException) {
                                  if (t instanceof ConnectException) {
                                      ToastUtil.showToast("网络未连接");
                                  } else {
                                      ToastUtil.showToast("网络错误");
                                  }
                              }
                              onError();
                          }
                      }
        );
    }

    protected void onError() {

    }

    protected void onFailure(ResponseResult responseResult) {

    }
}
