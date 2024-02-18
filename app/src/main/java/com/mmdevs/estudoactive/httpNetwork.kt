package com.mmdevs.estudoactive
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class HttpNetwork {

		companion object{
			const val  BASE_URL = "https://valorant-api.com/"
			private val _client = OkHttpClient
				.Builder()
				.addInterceptor(HttpLoggingInterceptor().apply {
					level = HttpLoggingInterceptor.Level.BODY
				})
				.build()
			val apiClient = Retrofit.Builder()
				.baseUrl(BASE_URL).client(_client)
				.addConverterFactory(MoshiConverterFactory.create())
				.build()
				.create(IAgentesServices::class.java)
		}


}