package smith.app.calculator.views

import android.content.Context
import android.util.AttributeSet
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import smith.app.calculator.R

class CalculatorOutputView(context: Context, attributeSet: AttributeSet) :
    LinearLayout(context, attributeSet), OutputInterface {

    private var equation: TextView
    private var result: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.view_output, this, true)

        orientation = VERTICAL
        gravity = Gravity.BOTTOM

        setBackgroundColor(context.getColor(R.color.surface))

        equation = findViewById(R.id.equation)
        result = findViewById(R.id.result)
    }

    fun addItem(item: String) {
        OutputPresenter.add(item)
    }

    fun removeItem() {
        OutputPresenter.remove()
    }

    fun solve() {
        OutputPresenter.solve()
    }

    fun clear() {
        OutputPresenter.clear()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        OutputPresenter.attach(this)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        OutputPresenter.detach()
    }

    override fun equation(equation: String) {
        this.equation.text = equation
    }

    override fun result(result: String) {
        this.result.text = result
    }
}