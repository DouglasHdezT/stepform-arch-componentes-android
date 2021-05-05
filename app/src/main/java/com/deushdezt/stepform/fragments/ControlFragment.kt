package com.deushdezt.stepform.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.deushdezt.stepform.R
import com.deushdezt.stepform.databinding.FragmentControlBinding
import com.deushdezt.stepform.viewmodels.FormViewModel
import java.lang.Exception

class ControlFragment: Fragment() {

    private val formViewModel: FormViewModel by activityViewModels()
    private lateinit var binding: FragmentControlBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentControlBinding.inflate(inflater, container, false).apply {
            viewmodel = formViewModel
            lifecycleOwner = viewLifecycleOwner
        }

        return binding.root
    }
}