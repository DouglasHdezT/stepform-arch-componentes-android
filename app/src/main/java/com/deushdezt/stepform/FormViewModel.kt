package com.deushdezt.stepform

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FormViewModel: ViewModel() {

    val firstname = MutableLiveData("")
    val lastname = MutableLiveData("")
    val age = MutableLiveData("")
    val email = MutableLiveData("")

    private val _current = MutableLiveData<Int>()
    val current: LiveData<Int>
        get() = _current

    private val _progress = MutableLiveData<Int>()
    val progress: LiveData<Int>
        get() = _progress


    private val formPages: List<Int>
        = listOf(R.id.formInitFragment, R.id.formPage1Fragment,
            R.id.formPage2Fragment, R.id.formResultsFragment)

    init {
        _current.value = 0
        _progress.value = 0
    }

    fun onNext() {
        _current.apply {
            value = value?.plus(1)?.coerceIn(0, formPages.lastIndex)
        }

        updateProgress()
    }

    fun onPrev(){
        _current.apply {
            value = value?.minus(1)?.coerceIn(0, formPages.lastIndex)
        }

        updateProgress()
    }

    fun updateProgress() {
        _progress.apply {
            value = ((current.value?.times(100F))?.div(formPages.lastIndex))?.toInt()
        }
    }

    fun getCurrentPage() = formPages[current.value?:0]

}