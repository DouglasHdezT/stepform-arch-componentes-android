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

class FormPage1Fragment: Fragment() {

    private val formViewModel: FormViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_form1, container, false)

        val nameField = view.findViewById<EditText>(R.id.name_form_input)
        val lastnameField = view.findViewById<EditText>(R.id.lastname_form_input)

        nameField.setText(formViewModel.firstname)
        lastnameField.setText(formViewModel.lastname)

        nameField.doAfterTextChanged {
            formViewModel.firstname = it.toString()
        }

        lastnameField.doAfterTextChanged {
            formViewModel.lastname= it.toString()
        }

        return  view
    }

}