package com.deushdezt.stepform.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.deushdezt.stepform.R
import com.deushdezt.stepform.viewmodels.FormViewModel
import java.lang.Exception
import java.lang.NumberFormatException

class FormPage2Fragment: Fragment() {

    private val formViewModel: FormViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form2, container, false)

        val ageField = view.findViewById<EditText>(R.id.age_form_input)
        val emailField = view.findViewById<EditText>(R.id.email_form_input)

        ageField.setText(formViewModel.age)
        emailField.setText(formViewModel.email)

        ageField.doAfterTextChanged {
            formViewModel.age = it.toString()
        }

        emailField.doAfterTextChanged {
            formViewModel.email = it.toString()
        }

        return view
    }

}