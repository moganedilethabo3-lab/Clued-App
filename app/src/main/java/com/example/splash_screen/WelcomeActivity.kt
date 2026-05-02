package com.example.splash_screen

import android.os.Bundle
import android.widget.AutoCompleteTextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import android.content.Intent
import android.widget.Button


class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()
        
        super.onCreate(savedInstanceState)


        Thread.sleep(3000)
        
        enableEdgeToEdge()
        setContentView(R.layout.welcome_screen)

        val explicitButton = findViewById<Button>(R.id.start_button)
        explicitButton.setOnClickListener {
            val intent = Intent(this,QuizActivity::class.java)
            startActivity(intent)
            finish()
        }

        
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val topicsList = listOf("Health and Wellness", "Cleaning", "Productivity")
        val autoComplete: AutoCompleteTextView = findViewById(R.id.auto_complete)
        
        val adapter = ArrayAdapter(this, R.layout.quiz_topics, topicsList)
        autoComplete.setAdapter(adapter)


        autoComplete.onItemClickListener = AdapterView.OnItemClickListener { adapterView, _, i, _ ->
            val selectedTopic = adapterView.getItemAtPosition(i).toString()
            Toast.makeText(this, "$selectedTopic selected", Toast.LENGTH_SHORT).show()
        }
    }
}
