package com.example.innovecstesttask.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.example.innovecstesttask.R
import com.example.innovecstesttask.actions_behavior.animation.RotateAnimation
import com.example.innovecstesttask.actions_behavior.notfication.LocalNotificationService
import com.example.innovecstesttask.data.result_handling.DataManager
import com.example.innovecstesttask.databinding.ActivityMainBinding
import com.example.innovecstesttask.mvi_mvvm.BaseState
import com.example.innovecstesttask.mvi_mvvm.ButtonActionState
import com.example.innovecstesttask.mvi_mvvm.MainScreenIntent
import com.example.innovecstesttask.mvi_mvvm.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.MainScope
import javax.inject.Inject


//@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val CALL_REQUEST_CODE = 101

//    @Inject
//    lateinit var manager: DataManager<*, *>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = activityMainBinding.root
        setContentView(rootView)

//        println(manager)

        activityMainBinding.actionButton.setOnClickListener {
            viewModel.obtainIntent(MainScreenIntent.ClickButtonIntent)
        }

        viewModel.viewState.observe(this) { state ->
            when (state) {
                is BaseState.LoadingState -> {
                    activityMainBinding.loadingView.progressBar.isVisible = true
                }

                is ButtonActionState.AnimationState -> {
                    activityMainBinding.loadingView.progressBar.isVisible = false
                    RotateAnimation().launchAnimation(activityMainBinding.actionButton, baseContext)
                }

                is ButtonActionState.CallState -> {
                    activityMainBinding.loadingView.progressBar.isVisible = false
                    val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
                    startActivityForResult(intent, CALL_REQUEST_CODE)
                }

                is ButtonActionState.NotificationState -> {
                    activityMainBinding.loadingView.progressBar.isVisible = false
                    val service = LocalNotificationService(context = baseContext)
                    service.showNotification()
                }

                is ButtonActionState.ToastState -> {
                    //todo: need to implement condition of checking internet connection
                    activityMainBinding.loadingView.progressBar.isVisible = false
                    Toast.makeText(
                        baseContext,
                        getString(R.string.toast_message),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}