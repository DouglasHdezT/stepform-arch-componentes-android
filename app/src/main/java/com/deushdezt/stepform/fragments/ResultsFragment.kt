package com.deushdezt.stepform.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.deushdezt.stepform.R
import com.deushdezt.stepform.viewmodels.FormViewModel

class ResultsFragment: Fragment() {

    private val formViewModel: FormViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_results, container, false)

        val nameText = view.findViewById<TextView>(R.id.name_result_text)
        val ageText = view.findViewById<TextView>(R.id.age_result_text)
        val email = view.findViewById<TextView>(R.id.email_result_text)

        val person = formViewModel.getPerson()

        nameText.text = getString(R.string.name_result_template, "${person.firstname} ${person.lastname}")
        ageText.text = getString(R.string.age_result_template, person.age)
        email.text = getString(R.string.email_result_template, person.email)

        return view
    }

}