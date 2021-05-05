package com.deushdezt.stepform.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.deushdezt.stepform.databinding.FragmentResultsBinding
import com.deushdezt.stepform.viewmodels.FormViewModel

class ResultsFragment: Fragment() {

    private val formViewModel: FormViewModel by activityViewModels()
    private lateinit var binding: FragmentResultsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultsBinding.inflate(inflater, container, false).apply {
            viewModel = formViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

}