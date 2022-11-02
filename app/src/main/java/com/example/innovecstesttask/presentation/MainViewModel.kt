package com.example.innovecstesttask.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.innovecstesttask.data.result_handling.ConfigurationDataManager
import com.example.innovecstesttask.data.result_handling.convertStringTypeIntoStateFormat
import com.example.innovecstesttask.data.repository.ActionConfigRepository
import com.example.innovecstesttask.data.result_handling.ErrorDataResult
import com.example.innovecstesttask.data.result_handling.SuccessDataResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel : BaseViewModel() {

    private var mutableLiveDataState: MutableLiveData<BaseState> = MutableLiveData()
    val viewState: LiveData<BaseState> = mutableLiveDataState

    override fun obtainIntent(intent: BaseUserIntent) {
        mutableLiveDataState.value = BaseState.LoadingState
        viewModelScope.launch {
            mutableLiveDataState.let {
                it.value = BaseState.LoadingState

                val resultData = withContext(Dispatchers.IO) {
                    ActionConfigRepository().fetchDataResult()
                }

                withContext(Dispatchers.Main) {
                    when (resultData) {
                        is SuccessDataResult -> {
                            val state =
                                ConfigurationDataManager().getHandledData(resultData.data).type.convertStringTypeIntoStateFormat()
                            mutableLiveDataState.value = state
                        }
                        is ErrorDataResult -> {
                            mutableLiveDataState.value = BaseState.ErrorState
                        }
                    }


                }
            }
        }
    }

}