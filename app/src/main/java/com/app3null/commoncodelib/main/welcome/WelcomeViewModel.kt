package com.app3null.commoncodelib.main.welcome

import com.app3null.basestructure.viewModels.BaseViewModel
import com.app3null.commoncodelib.main.welcome.actions.GoToDetailsScreenAction
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor() : BaseViewModel<WelcomeViewState>() {
    override fun getInitialState(): WelcomeViewState {
        return WelcomeViewState()
    }

    fun goToDetailsScreen() {
        dispatchAction(GoToDetailsScreenAction())
    }

}