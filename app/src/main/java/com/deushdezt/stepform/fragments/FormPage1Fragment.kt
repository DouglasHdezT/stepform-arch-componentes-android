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
import com.deushdezt.stepform.databinding.FragmentForm1Binding
import com.deushdezt.stepform.viewmodels.FormViewModel

class FormPage1Fragment: Fragment() {

    val formViewModel: FormViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentForm1Binding.inflate(inflater, container, false).apply {
            viewmodel = formViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root.apply {
            findViewById<EditText>(R.id.name_form_input).doAfterTextChanged {
                formViewModel.firstname = it.toString()
            }

            findViewById<EditText>(R.id.lastname_form_input).doAfterTextChanged {
                formViewModel.lastname = it.toString()
            }
        }
    }

}