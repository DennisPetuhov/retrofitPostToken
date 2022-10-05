package com.example.retrofitposttoken;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public class App extends Application {
    public static SharedPreferences sharedPreferences;
    private static Context context;




    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        sharedPreferences = context.getSharedPreferences("aaa", Context.MODE_PRIVATE);



    }

    public static Context getContext() {
        return context;
    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
