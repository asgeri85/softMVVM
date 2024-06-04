package net.asgeri.soft31may.api

import net.asgeri.soft31may.model.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("products")
    fun getAllProductsApi(): Call<List<ProductResponse>>

    @GET("products/{id}")
    fun getSingleProduct(@Path("id") id: String): Call<ProductResponse>


}