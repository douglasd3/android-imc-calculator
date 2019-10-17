package com.example.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initListeners()
    }

    private fun initListeners() {
        calculateButton.setOnClickListener {
            getValues()
        }
    }

    private fun getValues() {
        val height = heightEditText?.text?.toString()?.toFloatOrNull() ?: 1f
        val weight = weightEditText?.text?.toString()?.toFloatOrNull() ?: 0f

        val title = when(calcIMC(height, weight)) {
            in 0f..19f -> "Abaixo do peso"
            in 19f..25f -> "Peso ideal"
            else -> "Sobrepeso"
        }

        titleTextView.text = title
    }

    private fun calcIMC(height: Float, weight: Float) = weight / (height * height)

}
