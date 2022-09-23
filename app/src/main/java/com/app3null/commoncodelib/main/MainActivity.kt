package com.app3null.commoncodelib.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app3null.basestructure.activities.BaseActivity
import com.app3null.commoncodelib.main.navigation.NavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewState, MainViewModel>() {

    lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navHostController = rememberNavController()
            NavGraph(navController = navHostController)
        }
    }

    private val viewModel: MainViewModel by viewModels()


    override fun reflectState(viewState: MainViewState) {
    }

    override fun renderView(savedInstanceState: Bundle?) {
    }

    override fun provideViewModel(): MainViewModel {
        return viewModel
    }
}
