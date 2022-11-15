package com.example.retrofitposttoken;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.retrofitposttoken.DI.DaggerMyComponent;
import com.example.retrofitposttoken.DI.MyComponent;


public class App extends Application {
    public  MyComponent myComponent;
    public static SharedPreferences sharedPreferences;
    private static Context context;





    @Override
    public void onCreate() {
        super.onCreate();
       context = this;
        sharedPreferences = context.getSharedPreferences("aaa", Context.MODE_PRIVATE);
        myComponent= DaggerMyComponent.builder().createContext(this).build();



    }

   public static Context getContext() {        return context;    }

    public static SharedPreferences getSharedPreferences() {
        return sharedPreferences;
    }
}
