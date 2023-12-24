package smith.app.calculator.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import smith.app.calculator.R

class CalculatorInputView(context: Context, attributeSet: AttributeSet) : RelativeLayout(context, attributeSet) {

    private var click: View

    init {
        LayoutInflater.from(context).inflate(R.layout.view_input, this, true)

        attributeSet.run {
            val typedArray = context.obtainStyledAttributes(attributeSet,
                R.styleable.CalculatorInputView
            )

            val textResource = typedArray.getString(R.styleable.CalculatorInputView_itemText)
            val iconResource = typedArray.getResourceId(R.styleable.CalculatorInputView_itemIcon, -1)

            val tv = findViewById<TextView>(R.id.text)
            val iv = findViewById<ImageView>(R.id.image)
            click = findViewById(R.id.click)

            when {
                iconResource != -1 -> {
                    tv.visibility = GONE
                    iv.apply {
                        visibility = VISIBLE
                        setImageResource(iconResource)
                    }
                }
                !textResource.isNullOrEmpty() -> {
                    iv.visibility = GONE
                    tv.apply {
                        visibility = VISIBLE
                        text = textResource
                    }
                }
                else -> {
                    tv.visibility = GONE
                    iv.visibility = GONE
                }
            }

            typedArray.recycle()
        }

    }

    override fun setOnClickListener(l: OnClickListener?) {
        click.setOnClickListener(l)
    }
}
