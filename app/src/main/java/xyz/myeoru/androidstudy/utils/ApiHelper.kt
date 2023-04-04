package xyz.myeoru.androidstudy.utils

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiHelper {
    private val gson = GsonBuilder().setLenient().create()

    private fun createOkHttpClient(headers: List<Pair<String, String>>): OkHttpClient {
        val builder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val requestInterceptor = Interceptor { chain ->
            val request = chain.request().newBuilder().apply {
                headers.forEach {
                    addHeader(it.first, it.second)
                }
                method(chain.request().method, chain.request().body)
            }.build()

            chain.proceed(request)
        }
        builder.apply {
            addInterceptor(loggingInterceptor)
            addInterceptor(requestInterceptor)
        }
        return builder.build()
    }

    fun <T> create(
        service: Class<T>,
        baseUrl: String,
        headers: List<Pair<String, String>> = emptyList()
    ): T = Retrofit.Builder().apply {
        baseUrl(baseUrl)
        addConverterFactory(GsonConverterFactory.create(gson))
        client(createOkHttpClient(headers))
    }.build().create(service)
}