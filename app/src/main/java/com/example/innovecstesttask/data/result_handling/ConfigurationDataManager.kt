package com.example.innovecstesttask.data.result_handling

import com.example.innovecstesttask.data.repository.ActionConfig
import com.example.innovecstesttask.mvi_mvvm.ButtonActionState

class ConfigurationDataManager : DataManager<List<ActionConfig>, ActionConfig> {

    override fun getHandledData(data: List<ActionConfig>): ActionConfig {
        return data.getEnabledActions().getHighestPriorityAction()
    }

    private fun List<ActionConfig>.getEnabledActions() = filter { it.enabled }

    private fun List<ActionConfig>.getHighestPriorityAction() =
        sortedWith(compareByDescending { it.priority })[0]
}

fun String.convertStringTypeIntoStateFormat(): ButtonActionState {
    return when (this) {
        "animation" -> {
            ButtonActionState.AnimationState
        }
        "call" -> {
            ButtonActionState.AnimationState
        }
        "toast" -> {
            ButtonActionState.CallState
        }
        "notification" -> {
            ButtonActionState.NotificationState
        }
        else -> {
            ButtonActionState.NonDefinedState
        }
    }
}