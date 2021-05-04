package com.deushdezt.stepform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavHost
import com.deushdezt.stepform.fragments.ControlFragment
import com.deushdezt.stepform.viewmodels.FormViewModel

class MainActivity : AppCompatActivity(), ControlFragment.OnClickListener {

    private val formViewModel: FormViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_nav_host_fragment) as NavHost
        val navController = navHostFragment.navController

        formViewModel.current.observe(this){
            val fragmentId = formViewModel.getCurrentPageId()
            navController.navigate(fragmentId)
        }
    }

    override fun onNext() {
        formViewModel.onNext()
    }

    override fun onPrev() {
        formViewModel.onPrev()
    }
}