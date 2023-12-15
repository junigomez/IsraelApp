package com.example.israelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.israelapp.imccalculator.ImcCalculatorActivity
import com.example.israelapp.todoapp.TodoActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSaludApp = findViewById<Button>(R.id.SaludApp)

        val btnImcApp = findViewById<Button>(R.id.btnIMCApp)

        val btnTodo = findViewById<Button>(R.id.btnTodo)

        btnSaludApp.setOnClickListener{ navigateToSaludApp() }
        btnImcApp.setOnClickListener{ navigateToImcApp() }
        btnTodo.setOnClickListener { navigateTodo() }
    }

    private fun navigateTodo() {
        val intent = Intent (this, TodoActivity::class.java)
        startActivity(intent)

    }

    private fun navigateToImcApp() {
        val intent = Intent ( this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToSaludApp(){
        val intent = Intent(this, MainActivity2 :: class.java)
        startActivity(intent)
    }
}