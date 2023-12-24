package smith.app.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import smith.app.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val b: ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.clear.setOnClickListener { b.outputView.clear() }
        b.delete.setOnClickListener { b.outputView.removeItem() }
        b.equal.setOnClickListener { b.outputView.solve() }

        b.percent.setOnClickListener { b.outputView.addItem("%") }
        b.divide.setOnClickListener { b.outputView.addItem("/") }
        b.multiply.setOnClickListener { b.outputView.addItem("*") }
        b.minus.setOnClickListener { b.outputView.addItem("-") }
        b.plus.setOnClickListener { b.outputView.addItem("+") }

        b.point.setOnClickListener { b.outputView.addItem(".") }

        b.num00.setOnClickListener { b.outputView.addItem("00") }
        b.num0.setOnClickListener { b.outputView.addItem("0") }
        b.num1.setOnClickListener { b.outputView.addItem("1") }
        b.num2.setOnClickListener { b.outputView.addItem("2") }
        b.num3.setOnClickListener { b.outputView.addItem("3") }
        b.num4.setOnClickListener { b.outputView.addItem("4") }
        b.num5.setOnClickListener { b.outputView.addItem("5") }
        b.num6.setOnClickListener { b.outputView.addItem("6") }
        b.num7.setOnClickListener { b.outputView.addItem("7") }
        b.num8.setOnClickListener { b.outputView.addItem("8") }
        b.num9.setOnClickListener { b.outputView.addItem("9") }




    }
}