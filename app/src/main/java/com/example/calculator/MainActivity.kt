package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var counter = 0
    var num = false
    var dot = false

    fun ondigit(view: View)
    {
        val calculation = findViewById<TextView>(R.id.calculation)
        calculation.append((view as Button).text)
        num = true
    }

    fun equalto(view: View)
    {
        val calculation = findViewById<TextView>(R.id.calculation)
        if(num)
        {
            var output = calculation.text.toString()
            var prefix = ""
            if(output.startsWith("-"))
            {
                prefix ="-"
                output = output.substring(1)
            }
            if(output.contains("-"))
            {
                var split = output.split("-")

                var first = split[0]
                var second = split[1]

                if(!prefix.isEmpty())
                {
                    first = prefix + first
                }

                calculation.text = (first.toDouble() - second.toDouble()).toString()
            }

            else if(output.contains("+"))
            {
                var split = output.split("+")

                var first = split[0]
                var second = split[1]

                calculation.text = (first.toDouble() + second.toDouble()).toString()
            }

            else if(output.contains("*"))
            {
                var split = output.split("*")

                var first = split[0]
                var second = split[1]

                calculation.text = (first.toDouble() * second.toDouble()).toString()
            }

            else if(output.contains("/"))
            {
                var split = output.split("/")

                var first = split[0]
                var second = split[1]

                calculation.text = (first.toDouble() / second.toDouble()).toString()
            }
        }
    }

    fun clearer(view:View)
    {
        val calculation = findViewById<TextView>(R.id.calculation)
        calculation.text = ""
        num = false
        dot = false
    }

    fun decimal(view:View)
    {
        if(num && !dot)
        {
            val calculation = findViewById<TextView>(R.id.calculation)
            calculation.append(".")
            num = false
            dot = true
        }
    }

    fun operator(view: View)
    {
        val calculation = findViewById<TextView>(R.id.calculation)
        if(num && !isoperator(calculation.text.toString()))
        {
            calculation.append((view as Button).text)
            num = false
            dot = false
        }
    }

    fun isoperator(value: String): Boolean {
        return if(value.startsWith("-"))
        {
            false
        }
        else
        {
            value.contains("/") || value.contains("*") || value.contains("+") || value.contains("-")
        }
    }
}