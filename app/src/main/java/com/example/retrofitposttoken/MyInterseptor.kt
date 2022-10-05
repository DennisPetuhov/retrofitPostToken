package com.example.retrofitposttoken


import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

object MyInterseptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        println("!!!!" + request)
        var requestBuilder = request.newBuilder() // что вот тут?
       lateinit var newRequest: Request
        if (request.url()
                .equals("https://jwt-springsecurity.herokuapp.com/api/auth/signin") ||
            request.url()
                .equals("https://jwt-springsecurity.herokuapp.com/api/auth/signup")
        ){
         newRequest =   requestBuilder.build()
        }else{

            newRequest = requestBuilder
                .header("Authorisation", "Bearer ${App.getSharedPreferences().getString("EDIT_TEXT_KEY","")}")
                .build()
       println(newRequest.url())
       println(newRequest.header("Authorisation"))
        }


        return chain.proceed(newRequest)
            // доводить до конца и писать маленький проект, записывать собеседования


    }

}