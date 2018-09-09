package com.umbrella.financialteaching.utils;

import android.widget.Toast;

import com.umbrella.financialteaching.base.BaseApplication;

/**
 * Created by chenjun on 18/9/9.
 */

public class ToastUtil {

    private static Toast mToast;

    public static void showToast(CharSequence text) {
        if (mToast == null) {
            mToast = Toast.makeText(BaseApplication.getmInstance(), text, Toast.LENGTH_SHORT);
        } else {
            mToast.setText(text);
        }
        mToast.show();
    }
}
