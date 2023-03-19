package com.vk.housing.util;

import android.content.Context;
import android.content.SharedPreferences;

public class DataToPref {

    public static void setSharedPreferenceData(Context context, String PrefName, String key, String value) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PrefName, Context.MODE_PRIVATE);
        try {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.putString(key, value);
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getSharedPreferenceData(Context context, String PrefName, String key, String defaultValue) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PrefName, Context.MODE_PRIVATE);
        String userObjectString = sharedpreferences.getString(key, defaultValue);
        return userObjectString;
    }

    public static void clearPref(Context context, String PrefName) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(PrefName, Context.MODE_PRIVATE);
        try {
            SharedPreferences.Editor editor = sharedpreferences.edit();
            editor.clear();
            editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
