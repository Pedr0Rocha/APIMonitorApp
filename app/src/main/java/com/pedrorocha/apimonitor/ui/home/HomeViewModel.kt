package com.pedrorocha.apimonitor.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pedrorocha.apimonitor.data.Endpoint
import com.pedrorocha.apimonitor.data.HttpMethod
import com.pedrorocha.apimonitor.network.Repository

class HomeViewModel : ViewModel() {

    private val repository = Repository()

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    fun makeRequest() {
        val endpoint = Endpoint("G1", "https://g1.globo.com", HttpMethod.GET)
        repository.request(endpoint)
    }

}