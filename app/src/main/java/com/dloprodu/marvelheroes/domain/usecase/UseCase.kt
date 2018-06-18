package com.dloprodu.marvelheroes.domain.usecase

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

/**
 * Created by dloprodu on 17/03/2018.
 */
abstract class UseCase<T> {

    internal val disposables = CompositeDisposable()

    abstract fun buildCase(): Observable<T>

    fun execute(onSuccess: (value: T) -> Unit, onError: (t: Throwable) -> Unit = {}, onLoading: () -> Unit, onComplete: () -> Unit) {
        buildCase()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onLoading() }
                .doOnTerminate { onComplete() }
                .subscribe(onSuccess, onError)
                .addTo(disposables)
    }

    fun dispose() {
        disposables.clear()
        disposables.dispose()
    }

}