package com.app3null.commoncodelib.main

import com.app3null.basestructure.viewModels.BaseViewModel

class MainViewModel : BaseViewModel<MainViewState>() {
    override fun getInitialState(): MainViewState {
        return MainViewState
    }
}