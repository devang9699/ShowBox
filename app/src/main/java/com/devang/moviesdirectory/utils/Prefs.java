package com.devang.moviesdirectory.utils;

import android.app.Activity;
import android.content.SharedPreferences;

public class Prefs {

    SharedPreferences mSharedPreferences;

    public Prefs(Activity activity) {
        mSharedPreferences = activity.getPreferences(activity.MODE_PRIVATE);
    }

    public void setSearch(String search)
    {
        mSharedPreferences.edit().putString("search","Batman").commit();
    }

    public String getSearch()
    {
        return mSharedPreferences.getString("search","Batman");
    }
}
