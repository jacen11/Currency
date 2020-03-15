package com.pastukhov.currency.presentation

import android.util.Log
import com.pastukhov.chucknorris.business.Interactor
import com.pastukhov.currency.data.ApiService
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

    override fun showRate() {

        val from: String = view?.getSpnFrom() ?: ""
        val to: String = view?.getSpnTo() ?: ""
        val amount: String = view?.getNumber() ?: ""

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
