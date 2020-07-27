package com.pedrorocha.apimonitor.network

import com.google.gson.GsonBuilder
import com.pedrorocha.apimonitor.data.Endpoint
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Repository {

    private val client = OkHttpClient.Builder().build()
    private val gson = GsonBuilder().setLenient().create()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.google.com")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build();

    private val webservice: Webservice = retrofit.create(Webservice::class.java);

    fun request(endpoint: Endpoint) {
        val call = webservice.get(endpoint.url);

        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.code() == 200) {
                    println(response.body())
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                println(t.message)
                TODO("Not yet implemented")
            }
        })
    }
}