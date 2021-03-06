package com.pastukhov.currency.presentation

import android.util.Log
import com.pastukhov.currency.business.Interactor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(var interactor: Interactor) : IMainPresenter {

    private val compositeDisposable = CompositeDisposable()
    private var view: IMainView? = null

    override fun attachView(view: IMainView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun showRate(from: String, to: String,amount: String ) {

        compositeDisposable.add(
            interactor.getCurrency(from, to, amount)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { view?.setTxtResult(it.value) },
                    { Log.e("Presenter::showRate", "Error: $it") })
        )
    }
}
