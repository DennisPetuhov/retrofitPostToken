package com.example.retrofitposttoken.DI

import android.content.Context
import android.content.SharedPreferences
import com.example.retrofitposttoken.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [SharedPreferenciesModule::class,ApiModule::class])
interface MyComponent {

    fun inject(mainActivity: MainActivity)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun createContext(context: Context): Builder
        fun build(): MyComponent
    }
}