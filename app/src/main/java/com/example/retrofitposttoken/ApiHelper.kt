//package com.example.retrofitposttoken
//
//import com.squareup.moshi.Moshi
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import retrofit2.converter.moshi.MoshiConverterFactory
//import retrofit2.converter.scalars.ScalarsConverterFactory
//
//object ApiHelper {
//    val baseUrl = "https://jwt-springsecurity.herokuapp.com/"
//    val moshi=Moshi.Builder().build()
//   // var okHttpBuilder =OkHttpClient.Builder()
//
//
//   // var client= okHttpBuilder.build() // перенес из метода - есть ди разница?
//
//  var clientInterseptor =  OkHttpClient.Builder().addInterceptor(MyInterseptor).build()
//
//
//    fun getInstanceOfRetrofit(): PetApi {
//       // okHttpBuilder.addInterceptor(MyInterseptor)
//
//        val retrofit = Retrofit.Builder()
//            .baseUrl(baseUrl)
//            .client(clientInterseptor)
//           // .addConverterFactory(MoshiConverterFactory.create(moshi))
//              .addConverterFactory(ScalarsConverterFactory.create())
//           .addConverterFactory(GsonConverterFactory.create())
//            .build()
//        val petApi:PetApi = retrofit.create(PetApi::class.java) // про мета классы и апкастинг почитать
//        return petApi
//
//
//    }
//}