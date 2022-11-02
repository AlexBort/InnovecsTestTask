package com.example.innovecstesttask.mvi_mvvm

import androidx.lifecycle.ViewModel
import com.example.innovecstesttask.data.result_handling.DataManager

abstract class BaseViewModel : ViewModel() {
    abstract fun obtainIntent(intent: BaseUserIntent)
//    abstract fun getDataManager(): DataManager
}