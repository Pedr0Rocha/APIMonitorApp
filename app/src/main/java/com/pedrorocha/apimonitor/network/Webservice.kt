package com.pedrorocha.apimonitor.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface Webservice {

    @GET
    fun get(@Url url: String): Call<String>;

}