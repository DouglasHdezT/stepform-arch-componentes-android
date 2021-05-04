package com.deushdezt.stepform.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.deushdezt.stepform.R
import com.deushdezt.stepform.data.Person

class FormViewModel: ViewModel() {

    var firstname = ""
    var lastname = ""
    var age = ""
    var email = ""

    private val _current = MutableLiveData<Int>()
    val current: LiveData<Int>
        get() = _current

    init {
        _current.value = 0
    }

    private val formPages: List<Int> = listOf(R.id.formInitFragment, R.id.formPage1Fragment, R.id.formPage2Fragment, R.id.resultsFragment)

    fun getPerson() = Person(firstname, lastname, age.toIntOrNull()?:0, email)

    fun onNext(){
        _current.apply {
            value = value?.plus(1)?.coerceIn(0, formPages.lastIndex)
        }
    }

    fun onPrev() {
        _current.apply {
            value = value?.minus(1)?.coerceIn(0, formPages.lastIndex)
        }
    }

    fun getCurrentPageId() = formPages[_current.value?:0]
    fun getLastIndexOfList() = formPages.lastIndex
}