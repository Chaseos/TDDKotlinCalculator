package com.chase.tddkotlincalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.chase.tddkotlincalculator.presenter.CalcPresenter

class CalcActivity : AppCompatActivity(), View.OnClickListener, CalcView {
    private lateinit var topDisplay: TextView
    private lateinit var bottomDisplay: TextView
    private lateinit var calcPresenter : CalcPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initPresenter()
        initViews()
    }

    private fun initPresenter() {
        calcPresenter = CalcPresenter(this)
    }

    private fun initViews() {
        topDisplay = findViewById(R.id.top_textview)
        bottomDisplay = findViewById(R.id.bottom_textview)
        bottomDisplay.text = "0"
        findViewById<Button>(R.id.btn_0).setOnClickListener(this)
        findViewById<Button>(R.id.btn_1).setOnClickListener(this)
        findViewById<Button>(R.id.btn_2).setOnClickListener(this)
        findViewById<Button>(R.id.btn_3).setOnClickListener(this)
        findViewById<Button>(R.id.btn_4).setOnClickListener(this)
        findViewById<Button>(R.id.btn_5).setOnClickListener(this)
        findViewById<Button>(R.id.btn_6).setOnClickListener(this)
        findViewById<Button>(R.id.btn_7).setOnClickListener(this)
        findViewById<Button>(R.id.btn_8).setOnClickListener(this)
        findViewById<Button>(R.id.btn_9).setOnClickListener(this)
        findViewById<Button>(R.id.btn_add).setOnClickListener(this)
        findViewById<Button>(R.id.btn_subtract).setOnClickListener(this)
        findViewById<Button>(R.id.btn_multiply).setOnClickListener(this)
        findViewById<Button>(R.id.btn_divide).setOnClickListener(this)
        findViewById<Button>(R.id.btn_equals).setOnClickListener(this)
        findViewById<Button>(R.id.btn_clear).setOnClickListener(this)
    }

    override fun putNumberInBottomDisplay(bottomString: String) {
        bottomDisplay.text = bottomString
    }

    override fun putEquationInTopDisplay(topString: String) {
        topDisplay.text = topString
    }


    override fun showCalculatedResult(result: String) {
        bottomDisplay.text = result
    }

    override fun clearDisplays() {
        topDisplay.text = ""
        bottomDisplay.text = "0"
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_0 -> calcPresenter.checkToAppendBottom(getString(R.string.btn_0),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_1 -> calcPresenter.checkToAppendBottom(getString(R.string.btn_1),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_2 -> calcPresenter.checkToAppendBottom(getString(R.string.btn_2),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_3 -> calcPresenter.checkToAppendBottom(getString(R.string.btn_3),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_4 -> calcPresenter.checkToAppendBottom(getString(R.string.btn_4),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_5 -> calcPresenter.checkToAppendBottom(getString(R.string.btn_5),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_6 -> calcPresenter.checkToAppendBottom(getString(R.string.btn_6),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_7 -> calcPresenter.checkToAppendBottom(getString(R.string.btn_7),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_8 -> calcPresenter.checkToAppendBottom(getString(R.string.btn_8),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_9 -> calcPresenter.checkToAppendBottom(getString(R.string.btn_9),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_add -> calcPresenter.checkToAppendTop(getString(R.string.btn_add),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_subtract -> calcPresenter.checkToAppendTop(getString(R.string.btn_minus),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_multiply -> calcPresenter.checkToAppendTop(getString(R.string.btn_mult),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_divide -> calcPresenter.checkToAppendTop(getString(R.string.btn_div),
                    bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_equals -> calcPresenter.getCalculation(bottomDisplay.text as String, topDisplay.text as String)
            R.id.btn_clear -> clearDisplays()
        }
    }
}
