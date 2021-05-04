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
import com.deushdezt.stepform.viewmodels.FormViewModel
import java.lang.Exception

class ControlFragment: Fragment() {

    private lateinit var tools: OnClickListener
    private val formViewModel: FormViewModel by activityViewModels()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is OnClickListener){
            tools = context
        }else{
            throw Exception("ControlFragment context must implement its own OnClickListener interface")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_control, container, false)
        val progressbar = view.findViewById<ProgressBar>(R.id.form_progress_bar)

        formViewModel.current.observe(viewLifecycleOwner) {
            val progress = ((it * 100F) / (formViewModel.getLastIndexOfList())).toInt()
            progressbar.progress = progress
        }

        view.findViewById<Button>(R.id.prev_action).setOnClickListener {
            tools.onPrev()
        }

        view.findViewById<Button>(R.id.next_action).setOnClickListener {
            tools.onNext()
        }

        return view
    }

    interface OnClickListener {
        fun onNext()
        fun onPrev()
    }

}