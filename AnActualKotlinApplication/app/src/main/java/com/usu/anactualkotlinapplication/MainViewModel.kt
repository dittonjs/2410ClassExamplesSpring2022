package com.usu.anactualkotlinapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    val count: MutableLiveData<Int> = MutableLiveData()

    init {
        count.value = 0
        val ints = arrayOf(1,2,3,4,5,5)

        ints.forEach {  }
    }

    fun increment() {
        count.value = count.value?.plus(1)
    }

    fun decrement() {
        count.value = count.value?.minus(1)
    }
}