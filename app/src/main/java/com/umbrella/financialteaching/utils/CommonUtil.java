package com.umbrella.financialteaching.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import java.security.MessageDigest;
import java.util.List;

/**
 * Created by chenjun on 18/9/9.
 */

public class CommonUtil {

    public static String md5(String paramString) {
        String md5Str;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(paramString.getBytes());
            return byteToHexString(md5.digest());
        } catch (Exception e) {
            return paramString;
        }
    }

    public static String byteToHexString(byte[] b) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            String hex = Integer.toHexString(b[i] & 0xFF);
            if (hex.length() == 1) {
                hex = "0" + hex;
            }
            hexString.append(hex.toUpperCase());
        }
        return hexString.toString();
    }

    public static void callPhone(Context context, final String phone) {
        Intent phoneIntent = new Intent();
        phoneIntent.setAction(Intent.ACTION_CALL);
        phoneIntent.setData(Uri.parse("tel:" + phone));
        context.startActivity(phoneIntent);
    }

    public static boolean isServiceWork(Context context, String serviceName) {
        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> list = activityManager.getRunningServices(40);
        if (list.size() <= 0) {
            return false;
        }

        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i).service.getClassName().toString();
            if (name.equals(serviceName)) {
                return true;
            }
        }
        return false;
    }

    public static String getVersionName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo info = packageManager.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }
}
