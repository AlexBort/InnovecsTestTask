package com.example.innovecstesttask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.innovecstesttask.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = activityMainBinding.root
        setContentView(rootView)

        activityMainBinding.actionButton.setOnClickListener {

        }
    }
}