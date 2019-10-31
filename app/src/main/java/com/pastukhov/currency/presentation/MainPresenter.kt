package com.pastukhov.currency.presentation

import com.pastukhov.currency.data.ApiService
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter  @Inject constructor(var apiService:ApiService) : IMainPresenter {



    private val compositeDisposable = CompositeDisposable()
    private var view: IMainView? = null

    override fun attachView(view: IMainView) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun showRate() {

//        view?.getSpnFrom()
//        view?.getSpnTo()

       // apiService.getRate()

        view?.setTxtResult("test")

    }


}