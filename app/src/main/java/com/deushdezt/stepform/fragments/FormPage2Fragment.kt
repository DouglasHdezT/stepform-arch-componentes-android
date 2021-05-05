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
import com.deushdezt.stepform.databinding.FragmentForm2Binding
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
        val binding = FragmentForm2Binding.inflate(inflater, container, false).apply {
            viewmodel = formViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }

}