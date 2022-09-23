package com.app3null.common_code.extensions

import android.content.Context
import com.app3null.common_code.Log
import com.app3null.common_code.mvvm.common.extensions.just
import io.reactivex.Completable
import io.reactivex.Observable
import java.net.ConnectException


fun Observable<*>.checkInternetConnect(context: Context): Observable<Boolean> {
    return this.flatMap {
        when (context.isConnected) {
            true -> true.just()
            else -> Observable.error(Throwable(ConnectException()))
        }
    }
}

fun Observable<CharSequence>.mapToString(): Observable<String> = this.map { it.toString() }


fun Observable<String>.notEmpty(): Observable<String> = this.filter { it.isNotEmpty() }

fun <T> Observable<T>.loggingAction(actionName: String = ""): Observable<T> {
    return this
        .doOnNext { Log.debug("success $actionName") }
        .doOnError { Log.debug("error $actionName: ${it.message}") }
}

fun Completable.loggingAction(actionName: String = ""): Completable {
    return this
        .doOnComplete { Log.debug("success $actionName") }
        .doOnError { Log.debug("error $actionName: ${it.message}") }
}

fun <T> Observable<T>.takeFirst(): Observable<T> {
    return this.take(1)
}