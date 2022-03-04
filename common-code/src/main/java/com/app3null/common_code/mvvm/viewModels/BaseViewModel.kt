package com.app3null.common_code.mvvm.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app3null.common_code.mvvm.actions.ViewStateAction
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel<VIEW_STATE> :
    ViewModel() {

    private val liveViewState = MutableLiveData<VIEW_STATE>()

    protected val compositeDisposable = CompositeDisposable()

    private var currentState: VIEW_STATE? = null

    protected fun registerDisposables(vararg disposables: Disposable) {
        compositeDisposable.addAll(*disposables)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
        compositeDisposable.clear()
    }

    fun dispatchAction(viewStateAction: ViewStateAction<VIEW_STATE>) {
        sendState(viewStateAction.newState(currentState ?: getInitialState()))
    }

    private fun sendState(state: VIEW_STATE) {
        this.currentState = state
        liveViewState.postValue(currentState!!)
    }

    protected abstract fun getInitialState(): VIEW_STATE

    fun getLiveViewState(): LiveData<VIEW_STATE> {
        return liveViewState
    }

}