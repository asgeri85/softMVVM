package net.asgeri.soft31may.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private val retrofit = Retrofit.Builder().baseUrl("https://api.escuelajs.co/api/v1/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        fun createService(): ProductService {
            return retrofit.create(ProductService::class.java)
        }
    }

}