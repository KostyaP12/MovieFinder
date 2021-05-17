package com.geekbrains.moviefinder.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geekbrains.moviefinder.Repository.AppState
import com.geekbrains.moviefinder.Repository.Repository
import com.geekbrains.moviefinder.Repository.RepositoryImpl

class MainViewModel(
    private val liveDataToObserve: MutableLiveData<AppState> = MutableLiveData(),
    private val repositoryImpl: Repository = RepositoryImpl()
) : ViewModel() {
    fun getLiveData() = liveDataToObserve

    fun getMovieFromLocalSource() = getDataFromLocalSource()

    private fun getDataFromLocalSource() {
        liveDataToObserve.value = AppState.Loading
        Thread {
            Thread.sleep(1000)
            liveDataToObserve.postValue(AppState.Success(repositoryImpl.getMovieFromServer()))
        }.start()
    }
}