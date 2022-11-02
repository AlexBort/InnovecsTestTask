package com.example.innovecstesttask.actions.animation

import android.content.Context
import android.view.View

interface AnimBehavior {
    fun launchAnimation(animatedView: View, context: Context)
}