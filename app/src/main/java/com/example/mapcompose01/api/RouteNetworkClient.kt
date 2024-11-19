package com.example.mapcompose01.api

import com.example.mapcompose01.data.network.DirectionsApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

//object RouteNetworkClient {
//
////        private val okHttpClient by lazy {
////            createOkHttpClient()
////        }
////
////        private fun createOkHttpClient(): OkHttpClient {
////            val interceptor = HttpLoggingInterceptor()
////            interceptor.level = HttpLoggingInterceptor.Level.BODY
////
////            return OkHttpClient.Builder()
////                .connectTimeout(20, TimeUnit.SECONDS)
////                .readTimeout(20, TimeUnit.SECONDS)
////                .writeTimeout(20, TimeUnit.SECONDS)
////                .addNetworkInterceptor(interceptor)
////                .build()
////        }
//
//    val retrofit: DirectionsApiService by lazy {
//        Retrofit.Builder()
//            .baseUrl("https://maps.googleapis.com/maps/api/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(DirectionsApiService::class.java)
//    }
//
//
//
////        private val retrofit = Retrofit.Builder()
////            .baseUrl("https://maps.googleapis.com/maps/api/")
////            .client(okHttpClient)
////            .addConverterFactory(GsonConverterFactory.create())
////            .build()
////
////        val directionsApiService: DirectionsApiService =
////            retrofit.create(DirectionsApiService::class.java)
//}

object RouteNetworkClient {
    private
    const val BASE_URL = "https://maps.googleapis.com/maps/api/"
    val directionsApiService: DirectionsApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(DirectionsApiService::class.java)
    }
}