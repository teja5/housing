package com.vk.housing.util;

import android.app.Activity;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.vk.housing.data.remote.dao.User;

public class Util {

    public static String getString(EditText editText){
        return editText.getText().toString();
    }

    public static void setUser(Context context, User user) {
        Gson userGson = new Gson();
        String userData = userGson.toJson(user);
        DataToPref.setSharedPreferenceData(context, Constant.APP, Constant.USER, userData);
    }

    public static User getUser(Context context) {
        try{
            String userData = DataToPref.getSharedPreferenceData(context, Constant.APP, Constant.USER, "");
            Gson gson = new Gson();
            User user = gson.fromJson(userData, User.class);
            return user;
        }catch (Exception e){
            return new User();
        }
    }

    public static void showError(Activity activity, String message){
        Toast.makeText(activity,message,Toast.LENGTH_SHORT).show();
    }
}
