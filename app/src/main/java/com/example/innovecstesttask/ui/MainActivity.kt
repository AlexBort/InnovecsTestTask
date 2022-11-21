package com.example.innovecstesttask.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.innovecstesttask.R
import com.example.innovecstesttask.actions.animation.RotateAnimation
import com.example.innovecstesttask.actions.notfication.LocalNotificationService
import com.example.innovecstesttask.databinding.ActivityMainBinding
import com.example.innovecstesttask.presentation.BaseState
import com.example.innovecstesttask.presentation.ButtonActionState
import com.example.innovecstesttask.presentation.MainScreenIntent
import com.example.innovecstesttask.presentation.MainViewModel
import kotlinx.coroutines.flow.collectLatest

class MainActivity : AppCompatActivity() {

    private lateinit var activityMainBinding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    private val CALL_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        val rootView = activityMainBinding.root
        setContentView(rootView)

        activityMainBinding.actionButton.setOnClickListener {
            viewModel.obtainIntent(MainScreenIntent.ClickButtonIntent)
        }

        lifecycleScope.launchWhenStarted {
                viewModel.readDataFlow.collectLatest { state ->
                    state?.let {
                        when (state) {
                            is BaseState.LoadingState -> {
                                activityMainBinding.loadingView.progressBar.isVisible = true
                            }

                            is ButtonActionState.AnimationState -> {
                                activityMainBinding.loadingView.progressBar.isVisible = false
                                RotateAnimation().launchAnimation(
                                    activityMainBinding.actionButton,
                                    baseContext
                                )
                            }

                            is ButtonActionState.CallState -> {
                                activityMainBinding.loadingView.progressBar.isVisible = false
                                val intent =
                                    Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
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



//        viewModel.viewState.observe(this) { state ->
//            when (state) {
//                is BaseState.LoadingState -> {
//                    activityMainBinding.loadingView.progressBar.isVisible = true
//                }
//
//                is ButtonActionState.AnimationState -> {
//                    activityMainBinding.loadingView.progressBar.isVisible = false
//                    RotateAnimation().launchAnimation(activityMainBinding.actionButton, baseContext)
//                }
//
//                is ButtonActionState.CallState -> {
//                    activityMainBinding.loadingView.progressBar.isVisible = false
//                    val intent = Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
//                    startActivityForResult(intent, CALL_REQUEST_CODE)
//                }
//
//                is ButtonActionState.NotificationState -> {
//                    activityMainBinding.loadingView.progressBar.isVisible = false
//                    val service = LocalNotificationService(context = baseContext)
//                    service.showNotification()
//                }
//
//                is ButtonActionState.ToastState -> {
//                    //todo: need to implement condition of checking internet connection
//                    activityMainBinding.loadingView.progressBar.isVisible = false
//                    Toast.makeText(
//                        baseContext,
//                        getString(R.string.toast_message),
//                        Toast.LENGTH_SHORT
//                    ).show()
//                }
//            }
//        }
    }
}