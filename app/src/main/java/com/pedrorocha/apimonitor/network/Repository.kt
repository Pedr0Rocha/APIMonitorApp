package com.pedrorocha.apimonitor.network

import com.pedrorocha.apimonitor.data.Endpoint
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    private val client = OkHttpClient.Builder().build();

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("")
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build();

    private val webservice: Webservice = retrofit.create(Webservice::class.java);

    fun request(endpoint: Endpoint) {
        val call = webservice.get(endpoint.url);

        call.enqueue(object : Callback<String> {
            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.code() == 200) {

                }
            }

            override fun onFailure(call: Call<String>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}