package com.chase.tddkotlincalculator

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.chase.tddkotlincalculator.presenter.CalcPresenter
import com.chase.tddkotlincalculator.presenter.CalcView

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

    override fun appendNumberToBottomDisplay(num: String) {
        var currentBottom = bottomDisplay.text as String
        if (currentBottom == "0") {
            currentBottom = ""
        }
        if (topDisplay.text.contains('=')) {
            topDisplay.text = currentBottom
            bottomDisplay.text = num
        } else {
            val combineStrings = currentBottom + num
            bottomDisplay.text = combineStrings
        }
    }

    override fun appendCalculationToTopDisplay(operator: String) {
        val currentBottom = bottomDisplay.text as String
        val currentTop = topDisplay.text as String
        val lastIndexTop = currentTop.lastIndex

        val lastCharTop = if (currentTop.isNotEmpty()) {
            currentTop[lastIndexTop]
        } else {
            'x'
        }

        if (currentBottom.isEmpty() &&
                lastCharTop == '+' || lastCharTop == '-' || lastCharTop == '*' || lastCharTop == '/') {
            val newTop = currentTop.replaceRange(IntRange(lastIndexTop, lastIndexTop), operator)
            topDisplay.text = newTop
            return
        }

        bottomDisplay.text = operator
        val combineStrings = "$currentTop $currentBottom $operator"
        topDisplay.text = combineStrings
        bottomDisplay.text = ""
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
            R.id.btn_0 -> appendNumberToBottomDisplay(getString(R.string.btn_0))
            R.id.btn_1 -> appendNumberToBottomDisplay(getString(R.string.btn_1))
            R.id.btn_2 -> appendNumberToBottomDisplay(getString(R.string.btn_2))
            R.id.btn_3 -> appendNumberToBottomDisplay(getString(R.string.btn_3))
            R.id.btn_4 -> appendNumberToBottomDisplay(getString(R.string.btn_4))
            R.id.btn_5 -> appendNumberToBottomDisplay(getString(R.string.btn_5))
            R.id.btn_6 -> appendNumberToBottomDisplay(getString(R.string.btn_6))
            R.id.btn_7 -> appendNumberToBottomDisplay(getString(R.string.btn_7))
            R.id.btn_8 -> appendNumberToBottomDisplay(getString(R.string.btn_8))
            R.id.btn_9 -> appendNumberToBottomDisplay(getString(R.string.btn_9))
            R.id.btn_add -> appendCalculationToTopDisplay("+")
            R.id.btn_subtract -> appendCalculationToTopDisplay("-")
            R.id.btn_multiply -> appendCalculationToTopDisplay("*")
            R.id.btn_divide -> appendCalculationToTopDisplay("/")
            R.id.btn_equals -> showCalculatedResult("3")
            R.id.btn_clear -> clearDisplays()
        }
    }
}
