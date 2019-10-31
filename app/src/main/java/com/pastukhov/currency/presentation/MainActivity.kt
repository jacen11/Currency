package com.pastukhov.currency.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pastukhov.currency.R
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import androidx.core.view.get
import com.pastukhov.currency.App


class MainActivity : AppCompatActivity(), IMainView {

    @Inject
    lateinit var presenter: IMainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.appComponent?.inject(this)

        btnConvert.setOnClickListener {
            presenter.showRate()
        }
    }


    override fun onDestroy() {
        super.onDestroy()

        if (isFinishing) {
//            App.appComponent = null
        }
    }

    override fun getSpnTo() = spnTo.selectedItem.toString()


    override fun getSpnFrom() = spnFrom.selectedItem.toString()

    override fun setTxtResult(txt: String) {
        txtResult.text = txt
    }

}
