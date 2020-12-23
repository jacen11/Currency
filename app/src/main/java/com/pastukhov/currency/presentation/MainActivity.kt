package com.pastukhov.currency.presentation

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.pastukhov.currency.App
import com.pastukhov.currency.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), IMainView {

    @Inject
    lateinit var presenter: IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {

        App.appComponent?.inject(this)
        presenter.attachView(this)

        ArrayAdapter
            .createFromResource(this, R.array.listCurrencies, R.layout.spinner_item)
            .also { adapter ->
                adapter.setDropDownViewResource(R.layout.spinner_dropdown_item)
                spnFrom.adapter = adapter
                spnTo.adapter = adapter
            }
        val to = spnTo.selectedItem.toString()
        val from = spnFrom.selectedItem.toString()
        val amount = txtNumber.text.toString()

        val onLayoutChangeListener =
            View.OnLayoutChangeListener { _, _, _, _, _, _, _, _, _ ->
                presenter.showRate(to, from, amount)
            }

        txtNumber.addTextChangedListener { presenter.showRate(to, from, it.toString()) }
        spnFrom.addOnLayoutChangeListener(onLayoutChangeListener)
        spnTo.addOnLayoutChangeListener(onLayoutChangeListener)
    }

    override fun onDestroy() {
        super.onDestroy()

        if (isFinishing) {
            App.appComponent = null
            presenter.detachView()
        }
    }

    override fun getSpnTo() = spnTo.selectedItem.toString()

    override fun getSpnFrom() = spnFrom.selectedItem.toString()

    override fun getNumber() = txtNumber.text.toString()

    override fun setTxtResult(txt: String) {
        txtResultConvert.text = txt
    }

}
