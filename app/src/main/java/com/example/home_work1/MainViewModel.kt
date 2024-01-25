package com.example.home_work1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.Transformations


class MainViewModel : ViewModel() {
    private var counter = 0
    private val _counterLv = MutableLiveData<Int>()

    val counterLv: LiveData<Int> =
        Transformations.distinctUntilChanged(Transformations.map(_counterLv) { it })


    fun dec() {
        _counterLv.value = --counter
    }

    fun inc() {
        _counterLv.value = ++counter
    }
}