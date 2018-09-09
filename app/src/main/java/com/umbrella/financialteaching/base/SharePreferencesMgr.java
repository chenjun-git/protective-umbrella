package com.umbrella.financialteaching.base;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by chenjun on 18/9/9.
 */

public class SharePreferencesMgr {
    private static Context mContext;
    private static SharedPreferences mSharePreferences;

    private SharePreferencesMgr(Context context, String fileName) {
        this.mContext = context;
        mSharePreferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    public static void init(Context context, String fileName) {
        new SharePreferencesMgr(context, fileName);
    }

    public static int getInt(String key, int defaultValue) {
        if (mSharePreferences == null) {
            return defaultValue;
        }
        return mSharePreferences.getInt(key, defaultValue);
    }

    public static void setInt(String key, int value) {
        if (mSharePreferences == null) {
            return;
        }
        mSharePreferences.edit().putInt(key, value).commit();
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        if (mSharePreferences == null) {
            return defaultValue;
        }
        return mSharePreferences.getBoolean(key, defaultValue);
    }

    public static void setBoolean(String key, boolean value) {
        if (mSharePreferences == null) {
            return;
        }
        mSharePreferences.edit().putBoolean(key, value).commit();
    }

    public static String getString(String key, String defaultValue) {
        if (mSharePreferences == null) {
            return defaultValue;
        }
        return mSharePreferences.getString(key, defaultValue);
    }

    public static void setString(String key, String value) {
        if (mSharePreferences == null) {
            return;
        }
        mSharePreferences.edit().putString(key, value).commit();
    }

    public static void clearAll() {
        if (mSharePreferences == null) {
            return;
        }
        mSharePreferences.edit().clear().commit();
    }
}
