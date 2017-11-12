package com.chase.tddkotlincalculator.presenter

import com.chase.tddkotlincalculator.CalcView
import com.chase.tddkotlincalculator.model.CalcModel

class CalcPresenter(private val calcView: CalcView): CalcPresenterInt {
    private val calcModel = CalcModel()

    override fun getCalculation(bottomText: String, topText: String) {
        val numOneAndOperator = topText.split(" ")
        val newTop = "$topText $bottomText ="
        calcView.putEquationInTopDisplay(newTop)
        calcView.showCalculatedResult(calcModel.calculate(bottomText.toDouble(),
                numOneAndOperator[1].toDouble(), numOneAndOperator[2]).toString())
    }

    override fun checkToAppendBottom(num: String, bottomText: String, topText: String) {
        var currentBottom = bottomText
        if (bottomText == "0") {
            currentBottom = ""
        }
        if (topText.contains('=')) {
            calcView.putEquationInTopDisplay("")
            calcView.putNumberInBottomDisplay(num)
        } else {
            currentBottom += num
            calcView.putNumberInBottomDisplay(currentBottom)
        }
    }

    override fun checkToAppendTop(operator: String, bottomText: String, topText: String) {
        var newTop = topText
        val lastIndexTop = topText.lastIndex
        val lastCharTop = if (topText.isNotEmpty()) {
            topText[lastIndexTop]
        } else {
            'x'
        }

        if (topText.contains('=')) {
            newTop = bottomText
        }

        if (bottomText.isEmpty() &&
                lastCharTop == '+' || lastCharTop == '-' || lastCharTop == '*' || lastCharTop == '/') {
            val newTop = topText.replaceRange(IntRange(lastIndexTop, lastIndexTop), operator)
            calcView.putEquationInTopDisplay(newTop)
            return
        }

        val combineStrings = "$newTop $bottomText $operator"
        calcView.putEquationInTopDisplay(combineStrings)
        calcView.putNumberInBottomDisplay("")
    }

}