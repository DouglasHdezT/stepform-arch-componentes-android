package com.deushdezt.stepform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavHost

class MainActivity : AppCompatActivity() {

    private val formViewModel: FormViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.main_nav_fragment) as NavHost

        val navController = navHostFragment.navController

        formViewModel.current.observe(this) {
            navController.navigate(formViewModel.getCurrentPage())
        }
    }
}