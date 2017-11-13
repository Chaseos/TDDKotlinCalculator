package com.chase.tddkotlincalculator.presenter

import com.chase.tddkotlincalculator.CalcView
import com.chase.tddkotlincalculator.model.CalcModel

class CalcPresenter(private val calcView: CalcView) : CalcPresenterInt {

    private val calcModel = CalcModel()
    private var continueCalculation = false

    override fun getCalculation(bottomText: String, topText: String) {
        if (bottomText.isEmpty()) {
            return
        } else if (topText.isNotEmpty() && !topText.contains('=')) {
            val numOneAndOperator = topText.trim().split(" ")
            val newTop = "$topText $bottomText ="
            val newBottom: String = calcModel.calculate(numOneAndOperator[0].toDouble(),
                    bottomText.toDouble(), numOneAndOperator[1]).toString()
            calcView.putEquationInTopDisplay(newTop.trim())
            calcView.showCalculatedResult(newBottom.trim())
            continueCalculation = !continueCalculation
        }
    }

    override fun continueCalculation(bottomText: String, topText: String, operator: String) {
        val numOneAndOperator = topText.trim().split(" ")

        val newTop = calcModel.calculate(numOneAndOperator[0].toDouble(),
                bottomText.toDouble(), numOneAndOperator[1]).toString() + " " +
                operator
        val newBottom = ""
        calcView.putEquationInTopDisplay(newTop.trim())
        calcView.showCalculatedResult(newBottom.trim())
    }

    override fun checkAndAppendBottom(num: String, bottomText: String, topText: String) {
        var currentBottom = bottomText
        if (bottomText == "0") {
            currentBottom = ""
        }

        if (topText.contains('=')) {
            calcView.putEquationInTopDisplay("")
            calcView.putNumberInBottomDisplay(num.trim())
        } else {
            currentBottom += num
            calcView.putNumberInBottomDisplay(currentBottom.trim())
        }
    }

    override fun checkAndAppendTop(operator: String, bottomText: String, topText: String) {
        var newTop = topText
        val lastIndexTop = topText.lastIndex
        val lastCharTop = if (topText.isNotEmpty()) {
            topText[lastIndexTop]
        } else {
            'x'
        }

        if (lastCharTop == '=') {
            newTop = "$bottomText $operator"
            calcView.putEquationInTopDisplay(newTop)
            calcView.putNumberInBottomDisplay("")
            return
        } else if (continueCalculation) {
            continueCalculation(bottomText, topText, operator)
            return
        } else if (bottomText.isEmpty() &&
                lastCharTop == '+' || lastCharTop == '-' || lastCharTop == '*' || lastCharTop == '/') {
            newTop = topText.replaceRange(IntRange(lastIndexTop, lastIndexTop), operator)
            calcView.putEquationInTopDisplay(newTop.trim())
            return
        }

        continueCalculation = !continueCalculation
        val combineStrings = "$newTop $bottomText $operator"
        calcView.putEquationInTopDisplay(combineStrings.trim())
        calcView.putNumberInBottomDisplay("")
    }

    override fun checkAndClearDisplays() {
        continueCalculation = false
        calcView.putNumberInBottomDisplay("0")
        calcView.putEquationInTopDisplay("")
    }
}