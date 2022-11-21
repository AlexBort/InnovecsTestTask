package com.example.innovecstesttask.presentation

import androidx.lifecycle.viewModelScope
import com.example.innovecstesttask.data.result_handling.ConfigurationDataManager
import com.example.innovecstesttask.data.result_handling.convertStringTypeIntoStateFormat
import com.example.innovecstesttask.data.repository.ActionConfigRepository
import com.example.innovecstesttask.data.result_handling.ErrorDataResult
import com.example.innovecstesttask.data.result_handling.SuccessDataResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : BaseViewModel() {

    private var mtbDataStateFlow = MutableStateFlow<BaseState?>(null) // hot mutable state flow for possibility of changing of value of it
    val readDataFlow = mtbDataStateFlow.asSharedFlow()/*flow<BaseState?> { mtbDataStateFlow }*/ // cold flow (will be active after calling of terminal operator) + read only

    /**
     * seems that problem was here:
     */
//    val readDataStateFlow = flow<BaseState?> { mtbDataStateFlow }
    //todo: need to implement it with COLD flow, not HOT

    override fun obtainIntent(intent: BaseUserIntent) {
        viewModelScope.launch {
        mtbDataStateFlow.value = BaseState.LoadingState
            mtbDataStateFlow.let {
                it.value = BaseState.LoadingState

                val resultData = withContext(Dispatchers.IO) {
                    ActionConfigRepository().fetchDataResult()
                }

                withContext(Dispatchers.Main) {
                    when (resultData) {
                        is SuccessDataResult -> {
                            val state =
                                ConfigurationDataManager().getHandledData(resultData.data).type.convertStringTypeIntoStateFormat()
                            mtbDataStateFlow.value = state
                        }
                        is ErrorDataResult -> {
                            mtbDataStateFlow.value = BaseState.ErrorState
                        }
                    }
                }
            }
        }
    }

}