package com.example.groupon.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.example.groupon.config.Constant;

/**
        *
        * 对偏好设置文件的操作
        *
        * 1) Context的getSharedPreferences(文件名,模式);
        * 2) Activity的getPreference(模式);获取以preference_activiy名的偏好设置文件
        * 3) PreferenceManager的getDefaultSharedPreferences(Context);
        *    获取preference_包名 偏好设置文件
        *    模式 Context_MODE_PRIVATE
        *
        * Created by li on 2017/6/15.
        */


public class SPUtil {

    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    //通过重载 以不同的方式获得偏好设置
    public SPUtil(Context context, String name) {
        sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public SPUtil(Context context){
        sp = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sp.edit();

    }

    public boolean isFirst() {

        return sp.getBoolean(Constant.FIRST, true);

    }

    public void  setFrist(boolean flag){
        editor.putBoolean(Constant.FIRST,flag);
        editor.commit();

    };


}
