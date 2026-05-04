package com.example.result_review_screen

import android.os.Bundle
import android.widget.Button

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.RecyclerView

class ReviewActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var btnBackHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.review_main)
        enableEdgeToEdge()
        recyclerView = findViewById(R.id.quizAns)
        btnBackHome = findViewById(R.id.btnBackHome)

        btnBackHome.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

    }
}