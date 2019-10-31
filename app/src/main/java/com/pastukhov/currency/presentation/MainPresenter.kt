package com.pastukhov.currency.presentation

import io.reactivex.disposables.CompositeDisposable

class MainPresenter  : IMainPresenter {


    private val compositeDisposable = CompositeDisposable()
    private var view: IMainView? = null

    override fun attachView(view: IMainView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun showRate() {

        view?.getSpnFrom()
        view?.getSpnTo()


        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}