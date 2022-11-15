package com.example.retrofitposttoken.DI


import com.example.retrofitposttoken.MyInterseptor
import com.example.retrofitposttoken.PetApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.OkHttpClient.Builder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

@Module

class ApiModule {
    @Provides
    fun provideInterceptor(myInterseptor: MyInterseptor): OkHttpClient {
     return   Builder().addInterceptor(myInterseptor).build()
    }
    @Provides
    fun provideApi(okHttpClient: OkHttpClient): PetApi {
        // okHttpBuilder.addInterceptor(MyInterseptor)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jwt-springsecurity.herokuapp.com/")
            .client(okHttpClient)
            // .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val petApi: PetApi = retrofit.create(PetApi::class.java) // про мета классы и апкастинг почитать
        return petApi


    }


}