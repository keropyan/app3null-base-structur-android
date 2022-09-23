package com.app3null.commoncodelib.main.welcome.actions

import com.app3null.basestructure.actions.ViewStateAction
import com.app3null.basestructure.models.DisposableValue
import com.app3null.commoncodelib.main.welcome.WelcomeViewState

class GoToDetailsScreenAction : ViewStateAction<WelcomeViewState> {
    override fun newState(oldState: WelcomeViewState): WelcomeViewState {
        return oldState.copy(goToDetailsScreen = DisposableValue(true))
    }
}

