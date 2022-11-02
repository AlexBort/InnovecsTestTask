package com.example.innovecstesttask.actions.animation

import android.content.Context
import android.view.View
import android.view.animation.AnimationUtils
import com.example.innovecstesttask.R

class RotateAnimation: AnimBehavior {

    private fun initAnimation(context: Context) = AnimationUtils.loadAnimation(
        context, R.anim.rotate_circle
    )

    override fun launchAnimation(animatedView: View, context: Context) {
        animatedView.startAnimation(initAnimation(context))
    }
}