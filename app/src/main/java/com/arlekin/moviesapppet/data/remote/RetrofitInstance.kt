package com.arlekin.moviesapppet.data.remote

import android.util.Log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.ResponseBody.Companion.toResponseBody


class PrettyLogger : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        Log.d("API", "➡️ Request: ${request.method} ${request.url}")

        val response = chain.proceed(request)
        val rawBody = response.body
        val bodyString = rawBody?.string()

        Log.d("API", "Response: $bodyString")

        val newBody = (bodyString ?: "").toResponseBody(rawBody?.contentType())

        return response.newBuilder()
            .body(newBody)
            .build()
    }
}


object RetrofitInstance {

    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val client = OkHttpClient.Builder()
        .addInterceptor(PrettyLogger())
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: MovieApi by lazy {
        retrofit.create(MovieApi::class.java)
    }

    fun parseError(body: ResponseBody?): String {
        return body?.string() ?: "Unknown error"
    }
}
