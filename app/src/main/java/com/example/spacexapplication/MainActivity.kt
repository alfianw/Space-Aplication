package com.example.spacexapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMoveActivityAbout: Button = findViewById(R.id.abountButton)
        btnMoveActivityAbout.setOnClickListener(this)

        val btnMoveActivity: Button = findViewById(R.id.exploreButton)
        btnMoveActivity.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.exploreButton -> {
                val moveIntent = Intent(this, ListCardSpace::class.java)
                startActivity(moveIntent)
            }
        }

        when (v.id) {
            R.id.abountButton -> {
                val moveIntent = Intent(this, About::class.java)
                startActivity(moveIntent)
            }
        }
    }
}