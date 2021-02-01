package com.example.pythogarastheorem

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        btnCalculate.setOnClickListener { view ->
            calculator(view)
        }
        Toast.makeText(this@MainActivity, "Welcome", Toast.LENGTH_SHORT).show()
    }

    @SuppressLint("WrongViewCast")
    fun calculator(view: View)
    {
        val Height = findViewById<EditText>(R.id.Height)
        val Base = findViewById<EditText>(R.id.Base)
        var Hite: Double = Height.getText().toString().toDouble()
        var Bass: Double = Base.getText().toString().toDouble()
        Bass *= Bass
        Hite *= Hite
        var Hypot = Bass + Hite
        Hypot = sqrt(Hypot)
        val Hypo = findViewById<TextView>(R.id.Hypo)
        Hypo.setText(Hypot.toString())
        Toast.makeText(this@MainActivity, "Thank You", Toast.LENGTH_SHORT).show()
    }
}