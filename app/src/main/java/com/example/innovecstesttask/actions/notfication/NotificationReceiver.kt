package com.example.innovecstesttask.actions.notfication

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val service = LocalNotificationService(context)
        service.showNotification()
    }
}