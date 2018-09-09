package com.umbrella.financialteaching.base;

/**
 * Created by chenjun on 18/9/9.
 */

public abstract class HtmlSubscribeCallBack extends BaseCallBack<String> {
    @Override
    public void onNext(String response) {
        onSuccess(response);
    }

    protected abstract void onSuccess(String response);
}
