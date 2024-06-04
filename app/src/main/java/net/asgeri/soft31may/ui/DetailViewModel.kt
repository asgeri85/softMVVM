package net.asgeri.soft31may.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import net.asgeri.soft31may.api.RetrofitClient
import net.asgeri.soft31may.model.ProductResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel : ViewModel() {

    private val api = RetrofitClient.createService()

    val detailData = MutableLiveData<List<String>>()

    fun getDataDetail(id: String) {
        api.getSingleProduct(id).enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    response.body()?.images?.let {
                        detailData.value = it
                    }
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {

            }

        })
    }
}