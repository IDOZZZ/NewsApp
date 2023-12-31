package com.idn.newsapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.idn.newsapp.data.NewsResponse
import com.idn.newsapp.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewsViewsModel : ViewModel() {

    private var _commonMuslimNews = MutableLiveData<NewsResponse>()
    val commonMuslimNews get() = _commonMuslimNews as LiveData<NewsResponse>

    private var _aboutAlQuranNews = MutableLiveData<NewsResponse>()
    val aboutAlQuranNews get() = _aboutAlQuranNews as LiveData<NewsResponse>

    private var _alJazeeraNews = MutableLiveData<NewsResponse>()
    val alJazeeraNews get() = _alJazeeraNews as LiveData<NewsResponse>

    private var _warningForMuslimNews = MutableLiveData<NewsResponse>()
    val warningForMuslimNews get() = _warningForMuslimNews as LiveData<NewsResponse>

    private var _searchNews = MutableLiveData<NewsResponse>()
    val searchNews get() = _searchNews as LiveData<NewsResponse>

    fun commonMuslimNews() {
        ApiClient.provideApiservice().getCommonNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("ViewModel", "onResponse: ${response.body()}")
                        _commonMuslimNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code " + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("ViewModel", "onFailure: " + t.localizedMessage)
                }
            })
    }

    fun aboutAlQuranNews() {
        ApiClient.provideApiservice().getAlQuranNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("ViewModel", "onResponse: ${response.body()}")
                        _aboutAlQuranNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code " + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("ViewModel", "onFailure: " + t.localizedMessage)
                }
            })
    }

    fun alJazeeraNews() {
        ApiClient.provideApiservice().getAljazeeraNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("ViewModel", "onResponse: ${response.body()}")
                        _alJazeeraNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code " + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("ViewModel", "onFailure: " + t.localizedMessage)
                }
            })
    }

    fun warningForMuslimNews() {
        ApiClient.provideApiservice().getWarningfirMuslimNews()
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("ViewModel", "onResponse: ${response.body()}")
                        _warningForMuslimNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code " + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("ViewModel", "onFailure: " + t.localizedMessage)
                }
            })
    }

    fun searchNews(query: String) {
        ApiClient.provideApiservice().getSearchNews(query)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    if (response.isSuccessful) {
                        Log.i("ViewModel", "onResponse: ${response.body()}")
                        _searchNews.postValue(response.body())
                    } else Log.e(
                        "ViewModel",
                        "onResponse: Call error with HTTP status code " + response.code()
                    )
                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    Log.e("ViewModel", "onFailure: " + t.localizedMessage)
                }
            })
    }
}