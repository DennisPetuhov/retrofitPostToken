package com.example.retrofitposttoken.DI

import android.content.Context
import android.content.SharedPreferences
import com.example.retrofitposttoken.App
import dagger.Module
import dagger.Provides

@Module

class SharedPreferenciesModule() {
    @Provides
    fun provideSharedPref(context: Context):SharedPreferences{
        return context.getSharedPreferences("aaa", Context.MODE_PRIVATE)
    }

}