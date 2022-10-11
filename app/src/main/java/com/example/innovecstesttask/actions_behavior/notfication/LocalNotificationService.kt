package com.example.innovecstesttask.actions_behavior.notfication

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.provider.ContactsContract
import androidx.core.app.NotificationCompat
import com.example.innovecstesttask.R
import com.example.innovecstesttask.ui.MainActivity

class LocalNotificationService(private val context: Context) {

    private val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    fun showNotification() {
        val activityIntent = Intent(context, MainActivity::class.java)
        val activityPendingIntent =
            PendingIntent.getActivity(context, 1, activityIntent, PendingIntent.FLAG_IMMUTABLE)

        val contactsIntent =  Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
        val pendingContacts = PendingIntent.getActivity(context,2,contactsIntent, PendingIntent.FLAG_IMMUTABLE)

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_notifications_24)
            .setContentTitle(context.getString(R.string.title_notification))
            .setContentText(context.getString(R.string.text_notification))
            .setContentIntent(activityPendingIntent)
            .addAction(R.drawable.ic_baseline_contacts_24, "Open a contact screen", pendingContacts)
            .build()
        manager.notify(1, notification)
    }

    companion object {
        const val CHANNEL_ID = "counter_channel"
    }
}