package com.umbrella.financialteaching.base;

import android.app.Application;

/**
 * Created by chenjun on 18/9/9.
 */

public class BaseApplication extends Application {
    private static BaseApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
        SharePreferencesMgr.init(this, "umbrella");
    }

    public static BaseApplication getmInstance() {
        return mInstance;
    }
}
