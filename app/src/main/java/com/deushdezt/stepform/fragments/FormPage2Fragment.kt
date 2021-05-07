package com.deushdezt.stepform.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.deushdezt.stepform.FormViewModel
import com.deushdezt.stepform.databinding.FormPage2FragmentBinding

class FormPage2Fragment: Fragment() {

    private var _binding: FormPage2FragmentBinding? = null
    private val binding get() = _binding!!

    private val formViewModel: FormViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FormPage2FragmentBinding.inflate(inflater, container, false)
            .apply {
                viewmodel = formViewModel
                lifecycleOwner = viewLifecycleOwner
            }
        return binding.root
    }

}