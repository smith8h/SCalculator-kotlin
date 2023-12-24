package smith.app.calculator.views

import androidx.core.text.isDigitsOnly
import bsh.Interpreter
import java.lang.Exception

object OutputPresenter {

    private var view: OutputInterface? = null
    private var currentEquation: String = ""
    private var currentResult: String = ""

    private val interpreter = Interpreter()

    fun attach(view: OutputInterface) {
        this.view = view
    }

    fun detach() {
        this.view = null
    }

    fun add(item: String) {
        if (item == ".") {
                if (!currentEquation.contains(".")) currentEquation += item
        } else if (!item.isDigitsOnly()) {
                currentEquation += if (currentEquation.endsWith("/") || currentEquation.endsWith("*")
                    || currentEquation.endsWith("+") || currentEquation.endsWith("-") || currentEquation.endsWith("%")) {
                    remove()
                    item
                } else item
        } else currentEquation += item

        updateEquation()
        calculateResult()
        updateResult()
    }

    fun remove() {
        currentEquation = if (currentEquation.length > 1) currentEquation.substring(0, currentEquation.length - 1) else ""
        updateEquation()
        calculateResult()
        updateResult()
    }

    fun solve() {
        if (currentResult.isNotEmpty()) {
            currentEquation = currentResult
            currentResult = ""
        }
        updateEquation()
        updateResult()
    }

    fun clear() {
        currentEquation = ""
        currentResult = ""
        updateEquation()
        updateResult()
    }

    private fun calculateResult() {
        if (currentEquation.isNotEmpty()) {
            try {
                interpreter.eval("result = $currentEquation")
                val result = interpreter.get("result")
                if (result != null && result is Int) currentResult = result.toString()
            } catch (e: Exception) {
                currentResult = ""
            }
        } else currentResult = ""
    }

    private fun updateEquation() {
        view?.equation(currentEquation)
    }

    private fun updateResult() {
        view?.result(currentResult)
    }

}