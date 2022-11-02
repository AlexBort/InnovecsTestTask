package com.example.innovecstesttask.presentation

sealed class BaseState {
    object LoadingState : BaseState()
    object ErrorState : BaseState()
}

sealed class ButtonActionState : BaseState() {
    object AnimationState : ButtonActionState()
    object CallState : ButtonActionState()
    object ToastState : ButtonActionState()
    object NotificationState : ButtonActionState()
    object NonDefinedState : ButtonActionState()
}

sealed class BaseUserIntent

sealed class MainScreenIntent : BaseUserIntent() {
    object ClickButtonIntent : BaseUserIntent()
}