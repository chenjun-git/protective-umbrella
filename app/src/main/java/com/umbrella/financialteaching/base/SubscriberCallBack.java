package com.umbrella.financialteaching.base;

import android.text.TextUtils;

import com.umbrella.financialteaching.utils.ToastUtil;

/**
 * Created by chenjun on 18/9/9.
 */

public abstract class SubscriberCallBack<T> extends BaseCallBack<ResponseResult<T>> {

    @Override
    public void onNext(ResponseResult response) {
        boolean isSuccess = (!TextUtils.isEmpty(response.messge) && response.messge.equals("success"))
                || !TextUtils.isEmpty(response.successs) && response.successs.equals("true");
        if (isSuccess) {
            onSuccess((T)response.data);
        } else {
            ToastUtil.showToast(response.messge);
            onFailure(response);
        }
    }

    protected abstract void onSuccess(T response);
}
