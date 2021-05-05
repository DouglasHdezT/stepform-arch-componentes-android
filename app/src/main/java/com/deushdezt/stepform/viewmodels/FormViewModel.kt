package com.deushdezt.stepform.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deushdezt.stepform.R
import com.deushdezt.stepform.data.Person

class FormViewModel: ViewModel() {

    var firstname = MutableLiveData("")
    var lastname = MutableLiveData("")

    val name: String
        get() = "${firstname.value} ${lastname.value}"

    var age = MutableLiveData("")
    var email = MutableLiveData("")

    private val _current = MutableLiveData<Int>()
    val current: LiveData<Int>
        get() = _current

    private val _progress = MutableLiveData<Int>()
    val progress: LiveData<Int>
        get() = _progress

    private val formPages: List<Int> = listOf(R.id.formInitFragment, R.id.formPage1Fragment, R.id.formPage2Fragment, R.id.resultsFragment)

    init {
        _current.value = 0
        updateProgress()
    }


    fun getPerson() = Person(firstname.value ?: "", lastname.value?: "", age.value?.toIntOrNull()?:0, email.value?: "")

    fun onNext(){
        _current.apply {
            value = value?.plus(1)?.coerceIn(0, formPages.lastIndex)
        }
        updateProgress()
    }

    fun onPrev() {
        _current.apply {
            value = value?.minus(1)?.coerceIn(0, formPages.lastIndex)
        }
        updateProgress()
    }

    private fun updateProgress() {
        _progress.apply {
            value = ((current.value?.times(100F))?.div(formPages.lastIndex))?.toInt()
        }
    }

    fun getCurrentPageId() = formPages[_current.value?:0]
}