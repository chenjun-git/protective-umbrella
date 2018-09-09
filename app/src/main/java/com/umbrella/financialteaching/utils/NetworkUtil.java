package com.umbrella.financialteaching.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by chenjun on 18/9/9.
 */

public class NetworkUtil {
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            return (info != null && info.isAvailable());
        }
    }
}
