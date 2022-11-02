package com.example.innovecstesttask.presentation

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    abstract fun obtainIntent(intent: BaseUserIntent)
}