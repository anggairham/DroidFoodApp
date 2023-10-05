package com.example.droidfoodapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn = findViewById<ConstraintLayout>(R.id.btn_start)
        val startBtnJava = findViewById<ConstraintLayout>(R.id.btn_start_java)
        startBtn.setOnClickListener {
            val moveIntent = Intent(this@MainActivity,HomeActivity::class.java)
            startActivity(moveIntent)
        }
        startBtnJava.setOnClickListener {
            val moveIntent = Intent(this@MainActivity,SampleHomeActivity::class.java)
            startActivity(moveIntent)
        }
    }
}