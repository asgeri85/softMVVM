package net.asgeri.soft31may.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.asgeri.soft31may.api.RetrofitClient
import net.asgeri.soft31may.model.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val api = RetrofitClient.createService()

    val productList = MutableLiveData<List<ProductResponse>>()
    val loading = MutableLiveData<Boolean>()


    fun getHomeData() {
        loading.value = true
        api.getAllProductsApi().enqueue(object : Callback<List<ProductResponse>> {
            override fun onResponse(
                call: Call<List<ProductResponse>>,
                response: Response<List<ProductResponse>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        productList.value = it
                        loading.value = false
                    }
                }

            }

            override fun onFailure(call: Call<List<ProductResponse>>, t: Throwable) {

            }
        })
    }

}