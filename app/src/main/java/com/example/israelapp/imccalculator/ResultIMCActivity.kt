package com.example.israelapp.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.israelapp.R
import com.example.israelapp.imccalculator.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescription:TextView

    private lateinit var btnRecalculate:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponents()
        initUI(result)
        initListeners()
    }

    private fun initListeners() {
        btnRecalculate.setOnClickListener { onBackPressed() }
    }

    private fun initUI(result: Double) {
        when(result) {
            in 0.00..18.50 -> { //bajo peso
                tvResult.text = getString(R.string.bajo_peso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))

                tvDescription.text = getString(R.string.bajo_peso_descripcion)
            }

            in 18.51..24.99 -> { //peso normal
                tvResult.text = getString(R.string.peso_normal)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))

                tvDescription.text = getString(R.string.peso_normal_descripcion)
            }

            in 25.00..29.99 -> { //sobrepeso
                tvResult.text = getString(R.string.sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.sobrepeso))

                tvDescription.text = getString(R.string.sobrepeso_descripcion)
            }

            in 30.00..99.00 -> { //obecidad
                tvResult.text = getString(R.string.obecidad)
                tvResult.setTextColor(ContextCompat.getColor(this, R.color.obecidad))

                tvDescription.text = getString(R.string.obecidad_descripcion)
            }
            else->{ //error
                tvIMC.text = getString(R.string.error)
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
            }

        }
    }

    private fun initComponents() {
        tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }


}